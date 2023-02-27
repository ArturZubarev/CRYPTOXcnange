package com.example.cryptoxcnange.controller.userController;

import com.example.cryptoxcnange.business.ExchangeRate;
import com.example.cryptoxcnange.dto.currency.CurrencyDTO;
import com.example.cryptoxcnange.dto.currency.DTOCurrencyConverter;
import com.example.cryptoxcnange.dto.user.UserDTO;
import com.example.cryptoxcnange.model.currency.Currency;
import com.example.cryptoxcnange.model.user.User;
import com.example.cryptoxcnange.repositrory.currencyRepository.CurrencyRepository;
import com.example.cryptoxcnange.repositrory.userRepository.UserRepository;
import com.example.cryptoxcnange.service.currencyService.CurrencyService;
import com.example.cryptoxcnange.service.userService.UserService;
import com.example.cryptoxcnange.dto.user.DTOUserConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final CurrencyService currencyService;
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;
    private final ExchangeRate exchangeRate;

    private final DTOUserConverter dtoUserConverter;
    private final DTOCurrencyConverter dtoCurrencyConverter;




    @GetMapping("/one")
    public Optional<User> getUserBySecret(@RequestBody User userToFind) {
        return userService.getUserBySecretKey(userToFind.getSecret());
    }


    @PostMapping("/creating")
    public ResponseEntity<?> createNewTrader(@RequestBody
                                             UserDTO userDTO) {
        String email = userDTO.getEmail();
        String userName = userDTO.getUserName();
        String role = userDTO.getRole();
        User userFromDTO = dtoUserConverter.convertDTOToUser(userDTO);

        Optional<User> userToCheck = userRepository.findByEmailAndUserName(email, userName);
        if (userToCheck.isPresent() || !role.equals("user")) {
            return
                    ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body(
                                    "This user was registered or you selected invalid role");
        } else

            userRepository.save(userFromDTO);

        return
                ResponseEntity.status(HttpStatus.CREATED)
                        .body(userFromDTO.getSecret());
    }


    @GetMapping("/curr")
    public List<Currency> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }

    @GetMapping("/rate")
    public Set<Map.Entry<String, Double>> getRate(@RequestBody CurrencyDTO currencyDTO){
        Map<String, Double> rateMap =exchangeRate.courseMap(currencyDTO);
        return rateMap.entrySet();

    }


}





