package com.example.cryptoxcnange.controller.traderController;

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

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final CurrencyService currencyService;
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;

    @GetMapping("/all")
    public List<User> getAllTraders() {
        return userService.getUsers();
    }


    @GetMapping("/findOne")
    public Optional<User> getUserBySecret(@RequestBody User userToFind) {

        return userService.getUserBySecretKey(userToFind.getSecret());


    }


    @PostMapping("/create")
    public ResponseEntity<?> createNewTrader(@RequestBody
                                             User user) {
        String email = user.getEmail();
        String userName = user.getUserName();
        String role = user.getRole();
        Optional<User> userToCheck = userRepository.findByEmailAndUserName(email, userName);
        if (userToCheck.isPresent() || ! role.equals("user")) {
            return
                    ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body(
                                    "This user was registered or you selected invalid role");
        } else


            user.setRole("user");
        userRepository.save(user);

        return
                ResponseEntity.status(HttpStatus.CREATED)
                        .body(user.getSecret());
    }


    @GetMapping("/curr")
    public List<Currency> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }


}





