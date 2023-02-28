package com.example.cryptoxcnange.business.user;

import com.example.cryptoxcnange.dto.currency.CurrencyDTO;
import com.example.cryptoxcnange.model.currency.Currency;
import com.example.cryptoxcnange.service.currencyService.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Component
public class ExchangeRate {
    private final CurrencyService currencyService;



    public Map<String, Double> courseMap(CurrencyDTO currencyDTO) {
        List<Currency> curList = currencyService.getAllCurrencies();
        Currency currencyToConvert = currencyService.getCurrencyByName(currencyDTO.getCurrencyName());
        Map<String, Double> rateMap = new HashMap<>();


        if (currencyToConvert != null) {
            for (Currency currency :
                    curList) {
                Double currencyOnePrice = currencyToConvert.getPrice();
                Double currencyTwoPrice = currency.getPrice();
                Double rate = currencyOnePrice/currencyTwoPrice;
                rateMap.put(currency.getName(), rate);

            }


        }
        return rateMap;

    }

    }
