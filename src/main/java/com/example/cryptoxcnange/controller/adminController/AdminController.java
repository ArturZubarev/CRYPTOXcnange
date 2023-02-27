package com.example.cryptoxcnange.controller.adminController;

import com.example.cryptoxcnange.business.PriceSetter;
import com.example.cryptoxcnange.dto.AdminDTO;
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
    private final PriceSetter priceSetter;

    @PostMapping("/new")
    public ResponseEntity<?> createNewAdmin(@RequestBody User incomeUser) {
        Optional<User> adminToCheck = userService.getUserBySecretKey(incomeUser.getSecret());
        if (adminToCheck.isPresent()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("this admin was registered");
        } else {
            incomeUser.setEmail(incomeUser.getEmail());
            incomeUser.setUserName(incomeUser.getUserName());
            incomeUser.setRole("admin");
            userRepository.save(incomeUser);
        }
        return ResponseEntity.status(HttpStatus.OK).body("admin created " + incomeUser.getSecret());
    }

    @PutMapping("/curr/price")
    public ResponseEntity<?> setCurrencyPrice(@RequestBody AdminDTO adminDTO) {
        System.out.println(adminDTO.getSecret());
        priceSetter.setCurrencyPrice(adminDTO);
        return ResponseEntity.status(HttpStatus.OK).body("ok");



        }
    }
