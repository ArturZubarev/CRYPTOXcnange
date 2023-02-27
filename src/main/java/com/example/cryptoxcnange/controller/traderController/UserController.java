package com.example.cryptoxcnange.controller.traderController;

import com.example.cryptoxcnange.dto.UserDTO;
import com.example.cryptoxcnange.model.currency.Currency;
import com.example.cryptoxcnange.model.user.User;
import com.example.cryptoxcnange.repositrory.currencyRepository.CurrencyRepository;
import com.example.cryptoxcnange.repositrory.userRepository.UserRepository;
import com.example.cryptoxcnange.service.currencyService.CurrencyService;
import com.example.cryptoxcnange.service.userService.UserService;
import com.example.cryptoxcnange.util.DTOUserConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    //    private final UserDTO userDTO;
    private final DTOUserConverter dtoUserConverter;

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        List<User> userFromRepoList = userService.getUsers();
        List<UserDTO> outputDTOList = new ArrayList<>();
        for (User user :
                userFromRepoList) {
            UserDTO outputDTO = dtoUserConverter.convertUserToDTO(user);
            outputDTOList.add(outputDTO);
        }
        return outputDTOList;
    }


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


}





