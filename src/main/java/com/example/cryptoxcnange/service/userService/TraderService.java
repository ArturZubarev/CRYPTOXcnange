package com.example.cryptoxcnange.service.userService;

import com.example.cryptoxcnange.model.user.User;
import com.example.cryptoxcnange.repositrory.userRepository.TraderRepository;
import com.example.cryptoxcnange.util.TraderNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class TraderService {
    private final TraderRepository traderRepository;


    public List<User> getAllTraders(){
        return traderRepository.findAll();
    }

    public User getTraderByID(int id){
        Optional<User> trader = traderRepository.getTraderById(id);
        return trader.orElseThrow(TraderNotFoundException::new);

    }
    @Transactional
    public void save(User trader){
        traderRepository.save(trader);
    }
}
