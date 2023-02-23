package com.example.cryptoxcnange.service.currencyService;

import com.example.cryptoxcnange.model.currency.Currency;
import com.example.cryptoxcnange.repositrory.currencyRepository.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public List<Currency> getAllCurrencies(){
        return currencyRepository.findAll();
    }

    public Optional<Currency> getCurrencyBalance(String name){
        return currencyRepository.findCurrencyByName(name);
    }

}
