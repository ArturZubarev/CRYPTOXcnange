package exchangeTransactions;

import com.example.cryptoxcnange.model.currency.Currency;
import com.example.cryptoxcnange.repositrory.currencyRepository.CurrencyRepository;
import com.example.cryptoxcnange.service.currencyService.CurrencyService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
public class PriceSetter {
    private  CurrencyService currencyService;
    private  CurrencyRepository currencyRepository;
    public void SetCurrencyPrice(Currency currency){
        String name = currency.getName();
        double price = currency.getPrice();

        Optional <Currency> currencyFromRepository = currencyService.getCurrencyByCurrencyName(name);
        if (currencyFromRepository.isPresent()){
            currencyRepository.save(currency);
        }
    }
}
