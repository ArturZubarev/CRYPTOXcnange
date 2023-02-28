package com.example.cryptoxcnange.business.admin;

import com.example.cryptoxcnange.dto.admin.AdminDTO;
import com.example.cryptoxcnange.model.currency.Currency;
import com.example.cryptoxcnange.model.user.User;
import com.example.cryptoxcnange.service.currencyService.CurrencyService;
import com.example.cryptoxcnange.service.userService.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@AllArgsConstructor
@Getter
@Setter
@Component
public class PriceSetter {
    @Autowired
    private final UserService userService;
    @Autowired
    private final CurrencyService currencyService;

    public void setCurrencyPrice(AdminDTO adminDTO) {
        ModelMapper modelMapper = new ModelMapper();

        Currency incomingCurrency = modelMapper.map(adminDTO, Currency.class);
        User adminToCheck = modelMapper.map(adminDTO, User.class);

        String secret = adminToCheck.getSecret();

        User adminFromRepository = userService.findUserBySecret(secret);


        String incomingCurrencyName = adminDTO.getCurrency_name();
        Double incomingCurrencyPrice = Double.valueOf(adminDTO.getCurrency_price());

        Currency currencyFromRepository =
                currencyService.getCurrencyByName(incomingCurrencyName);
        String currencyFromRepositoryName = currencyFromRepository.getName();


        if (currencyFromRepositoryName.equals(incomingCurrencyName) &&
                adminFromRepository.getRole().equals("admin")) {
            currencyFromRepository.setPrice(incomingCurrencyPrice);
            currencyService.save(currencyFromRepository);

        }
    }

}
