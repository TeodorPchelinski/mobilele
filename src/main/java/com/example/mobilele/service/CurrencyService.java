package com.example.mobilele.service;

import com.example.mobilele.model.dto.ExchangeRatesDTO;
import com.example.mobilele.model.entity.ExchangeRateEntity;

public interface CurrencyService {

    void refreshRates(ExchangeRatesDTO exchangeRatesDTO);

}
