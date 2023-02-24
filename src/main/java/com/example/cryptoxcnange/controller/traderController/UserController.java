package com.example.cryptoxcnange.controller.traderController;

import com.example.cryptoxcnange.model.currency.Currency;
import com.example.cryptoxcnange.model.user.User;
import com.example.cryptoxcnange.repositrory.userRepository.UserRepository;
import com.example.cryptoxcnange.service.currencyService.CurrencyService;
import com.example.cryptoxcnange.service.userService.UserService;
import com.example.cryptoxcnange.util.TraderErrorResponse;
import com.example.cryptoxcnange.util.TraderNotCreatedException;
import com.example.cryptoxcnange.util.TraderNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trader")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final CurrencyService currencyService;
    private final UserRepository userRepository;

    @GetMapping("/all")
    public List<User> getAllTraders() {
        return userService.getUsers();
    }


    @GetMapping("/findOne")
    public Optional<User> getUserBySecret(@RequestBody User userToFind){

       return userService.getUserBySecretKey(userToFind.getSecret());


    }


    @PostMapping("/create")
    public String createNewTrader(@RequestBody
                                  User user) {
        String email = user.getEmail();
        String userName = user.getUserName();
        Optional<User> userToCheck = userRepository.findByEmailAndUserName(email,userName);
        if (userToCheck.isPresent()){
            return "This user was registered";
        }
        else userRepository.save(user);
        return user.getSecret();
    }


    @GetMapping("/curr")
    public List<Currency> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }



}
