package com.example.mobilele.service;

import com.example.mobilele.model.entity.ExchangeRateEntity;

public interface CurrencyService {

    void refreshRates(ExchangeRateEntity exchangeRateEntity);

}
