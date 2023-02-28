package com.example.cryptoxcnange.service.currencyService;

import com.example.cryptoxcnange.model.currency.Currency;
import com.example.cryptoxcnange.repositrory.currencyRepository.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor

public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }


    public Currency getCurrencyByName(String currencyName) {
        return currencyRepository.findCurrencyByName(currencyName);
    }

    public void save(Currency currency){
        currencyRepository.save(currency);
    }
}

