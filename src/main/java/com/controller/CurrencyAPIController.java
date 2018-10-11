package com.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.model.CurrencyDetails;
import com.service.CurrencyDetailService;

@RestController
public class CurrencyAPIController {

  final static Logger logger = LoggerFactory.getLogger(CurrencyAPIController.class);
  
  @Autowired
  private CurrencyDetailService currencyDetailService;

  @RequestMapping(value = "/", produces = "application/json")
  public List<CurrencyDetails> getDetails() {
    logger.info("Call getDetails()");
    return currencyDetailService.getDetails();
  }
}
