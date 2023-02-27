package com.example.cryptoxcnange.util;

import com.example.cryptoxcnange.dto.UserDTO;
import com.example.cryptoxcnange.model.user.User;
import lombok.NoArgsConstructor;
@NoArgsConstructor
public class DTOUserConverter {
    public   User convertDTOToUser(UserDTO dto){
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setUserName(dto.getUserName());
        user.setRole("user");
        return user;
    }

}
