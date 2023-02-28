package com.example.cryptoxcnange.dto.user;

import com.example.cryptoxcnange.model.user.User;
import com.example.cryptoxcnange.util.SecretStringGenerator;
import lombok.NoArgsConstructor;
@NoArgsConstructor
public class DTOUserConverter {
    public   User convertDTOToUser(UserDTO dto){
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setUserName(dto.getUserName());
        user.setRole("user");
        user.setSecret(SecretStringGenerator.generateRandomString());
        return user;
    }

    public UserDTO convertUserToDTO(User user){
        UserDTO outputDTO = new UserDTO();
        outputDTO.setEmail(user.getEmail());
        outputDTO.setUserName(user.getUserName());
        outputDTO.setRole(user.getRole());
        return outputDTO;

    }

}
