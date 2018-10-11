package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.CurrencyDetails;
import com.repository.CurrencyDetailRepository;

@Service
public class CurrencyDetailService {
  
  @Autowired
  private CurrencyDetailRepository currencyDetailRepository;

  public List<CurrencyDetails> getDetails() {
    return currencyDetailRepository.findFirst10ByOrderByIdDesc();
  }

}
