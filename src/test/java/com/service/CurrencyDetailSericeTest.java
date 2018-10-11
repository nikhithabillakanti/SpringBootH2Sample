package com.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyDetailSericeTest {

  @Autowired
  CurrencyDetailService currencyDetailService;
  
  @Test
  public void shouldCheckResultReturnNotMoreThen10Records() {
    Integer total = currencyDetailService.getDetails().size();
    Assert.assertTrue(total < 11);
  }
}
