package com.example.cryptoxcnange.dto.currency;

import com.example.cryptoxcnange.model.currency.Currency;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DTOCurrencyConverter {
    private final  ModelMapper modelMapper;
    public Currency DTOToCurrencyConverter(CurrencyDTO currencyDTO){
        Currency currency = new Currency();
        currency.setName(currencyDTO.getCurrencyName());
        currency.setPrice(currency.getPrice());
        return currency;
    }

    public CurrencyDTO CurrencyToDTOConverter(Currency currency){
        CurrencyDTO currencyDTO = new CurrencyDTO();
        currencyDTO.setCurrencyName(currency.getName());
        currencyDTO.setPrice(currency.getPrice());
        return currencyDTO;
    }
}
