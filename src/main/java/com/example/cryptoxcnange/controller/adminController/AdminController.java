package com.example.cryptoxcnange.controller.adminController;

import com.example.cryptoxcnange.business.admin.PriceSetter;
import com.example.cryptoxcnange.dto.admin.AdminDTO;
import com.example.cryptoxcnange.dto.user.DTOUserConverter;
import com.example.cryptoxcnange.dto.user.UserDTO;
import com.example.cryptoxcnange.dto.user.UserDTOWithSecretKey;
import com.example.cryptoxcnange.model.user.User;
import com.example.cryptoxcnange.repositrory.userRepository.UserRepository;
import com.example.cryptoxcnange.service.userService.UserService;
import com.example.cryptoxcnange.util.SecretStringGenerator;
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
    private final UserRepository userRepository;
    private final PriceSetter priceSetter;
    private final DTOUserConverter dtoUserConverter;

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers(@RequestBody UserDTOWithSecretKey incomingUser) {
        List<User> userFromRepoList = userService.getUsers();
        List<UserDTO> outputDTOList = new ArrayList<>();
        for (User user :
                userFromRepoList) {
            UserDTO outputDTO = dtoUserConverter.convertUserToDTO(user);
            outputDTOList.add(outputDTO);
        }
        User adminToCheck = userService.findUserBySecret(incomingUser.getSecret());
        if (!adminToCheck.getRole().equals("admin")) {

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("forbidden");
        } else
            return ResponseEntity.status(HttpStatus.OK).body(outputDTOList);
    }


    @PostMapping("/new")
    public ResponseEntity<?> createNewAdmin(@RequestBody UserDTO userDTO) {
        Optional<User> userFromRepository = userService.findUserByEmailAndUsername(userDTO.getEmail(), userDTO.getUserName());
        User admin = new User();
        if (userFromRepository.isPresent()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("this admin was registered");
        } else {

            admin.setEmail(userDTO.getEmail());
            admin.setUserName(userDTO.getUserName());
            admin.setRole("admin");
            admin.setSecret(SecretStringGenerator.generateRandomString());
            userRepository.save(admin);
        }

        return ResponseEntity.status(HttpStatus.OK).body("admin created " + admin.getSecret());
    }


    @PatchMapping("/curr/price")
    public ResponseEntity<?> setCurrencyPrice(@RequestBody AdminDTO adminDTO) {
        priceSetter.setCurrencyPrice(adminDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Price " + adminDTO.getCurrency_name()
                + " " + "updated!");

    }


}
