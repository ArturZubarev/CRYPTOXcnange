package com.example.cryptoxcnange.service.userService;

import com.example.cryptoxcnange.model.user.User;
import com.example.cryptoxcnange.repositrory.userRepository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class UserService {
    private final UserRepository userRepository;


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserBySecretKey(String secret){
        return userRepository.findBySecret(secret);
    }

    public Optional<User> findUserByEmailAndUsername(String email, String userName){
        return userRepository.findByEmailAndUserName(email,userName);
    }

    public User findUserBySecret(String secret){
        return userRepository.findUserBySecret(secret);
    };


    @Transactional
    public void save(User trader){
        userRepository.save(trader);
    }
}
