package com.example.cryptoxcnange.controller.adminController;

import com.example.cryptoxcnange.business.PriceSetter;
import com.example.cryptoxcnange.dto.admin.AdminDTO;
import com.example.cryptoxcnange.dto.user.DTOUserConverter;
import com.example.cryptoxcnange.dto.user.UserDTO;
import com.example.cryptoxcnange.model.user.User;
import com.example.cryptoxcnange.repositrory.currencyRepository.CurrencyRepository;
import com.example.cryptoxcnange.repositrory.userRepository.UserRepository;
import com.example.cryptoxcnange.service.currencyService.CurrencyService;
import com.example.cryptoxcnange.service.userService.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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

    @PatchMapping("/curr/price")
    public ResponseEntity<?> setCurrencyPrice(@RequestBody AdminDTO adminDTO) {
        priceSetter.setCurrencyPrice(adminDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Price " + adminDTO.getCurrency_name()
                + " " + "updated!");

    }


}
