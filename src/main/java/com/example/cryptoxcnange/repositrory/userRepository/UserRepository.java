package com.example.cryptoxcnange.repositrory.userRepository;


import com.example.cryptoxcnange.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findBySecret(String secret);

    Optional<User> findByEmailAndUserName(String email,String username);




}
