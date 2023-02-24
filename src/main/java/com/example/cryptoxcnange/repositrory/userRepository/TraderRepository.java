package com.example.cryptoxcnange.repositrory.userRepository;


import com.example.cryptoxcnange.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TraderRepository extends JpaRepository<User, Long> {
    Optional<User> getTraderById(int id);


}
