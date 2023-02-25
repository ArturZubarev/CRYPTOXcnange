package com.example.cryptoxcnange.controller.adminController;

import com.example.cryptoxcnange.model.currency.Currency;
import com.example.cryptoxcnange.model.user.User;
import com.example.cryptoxcnange.repositrory.currencyRepository.CurrencyRepository;
import com.example.cryptoxcnange.repositrory.userRepository.UserRepository;
import com.example.cryptoxcnange.service.currencyService.CurrencyService;
import com.example.cryptoxcnange.service.userService.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private final UserService userService;
    private final CurrencyService currencyService;
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;

    @PostMapping("/new")
    public ResponseEntity<?> createNewAdmin(@RequestBody User incomeUser) {
        Optional<User> adminToCheck = userService.getUserBySecretKey(incomeUser.getSecret());
        if (adminToCheck.isPresent()){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("this admin was registered");
        }
        else {
            incomeUser.setEmail(incomeUser.getEmail());
            incomeUser.setUserName(incomeUser.getUserName());
            incomeUser.setRole("admin");
            userRepository.save(incomeUser);
        }
        return ResponseEntity.status(HttpStatus.OK).body("admin created " + incomeUser.getSecret());
    }

    @PatchMapping("/curr/price")
    public ResponseEntity<?> setCurrencyPrice(@RequestBody Currency currency, User incomingUser) {
        Currency fromRepo = currencyService.getCurrencyByCurrencyName(currency.getName());
        double price = currency.getPrice();
        String secret = incomingUser.getSecret();
        System.out.println(secret);
        User adminToCheck = userRepository.findUserBySecret(secret);
        if (adminToCheck.getRole().equals("admin")) {
            fromRepo.setPrice(price);
            currencyRepository.save(fromRepo);
            return ResponseEntity.status(HttpStatus.OK).body("course successfully updated!");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("forbidden");


        }
    }
}
