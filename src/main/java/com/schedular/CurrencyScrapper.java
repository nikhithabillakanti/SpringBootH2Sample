package com.schedular;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import com.model.CurrencyDetails;
import com.repository.CurrencyDetailRepository;
import com.utils.JsonReader;

@Controller
public class CurrencyScrapper {

  final static Logger logger = LoggerFactory.getLogger(CurrencyScrapper.class);
  
  @Autowired
  private CurrencyDetailRepository currencyDetailRepository;

  @Value("${currency.exchange.mode}")
  private String exchangeMode;

  @Value("${source.api.url}")
  private String sourceApiURL;

  /**
   * Call every 1 minute
   */
  @Scheduled(cron = "*/60 * * * * *")
  public void runEveryOnemin() throws IOException, JSONException {
    logger.info("Call runEveryOnemin()");
    String url = MessageFormat.format(sourceApiURL, exchangeMode);
    JSONObject json = JsonReader.readJsonFromUrl(url).getJSONObject(exchangeMode);
    Double value = (Double) json.get("val");
    CurrencyDetails currencyDetails = new CurrencyDetails();
    currencyDetails.setMode(exchangeMode);
    currencyDetails.setValue(value);
    currencyDetails.setFetchDate(new Date());
    currencyDetailRepository.save(currencyDetails);
    logger.info("Data :: " + currencyDetails.toString());
  }
}
