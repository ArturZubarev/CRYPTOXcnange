package com.example.cryptoxcnange.service.traderService;

import com.example.cryptoxcnange.model.role.Trader;
import com.example.cryptoxcnange.repositrory.traderRepository.TraderRepository;
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


    public List<Trader> getAllTraders(){
        return traderRepository.findAll();
    }

    public Trader getTraderByID(int id){
        Optional<Trader> trader = traderRepository.getTraderById(id);
        return trader.orElseThrow(TraderNotFoundException::new);

    }
    @Transactional
    public void save(Trader trader){
        traderRepository.save(trader);
    }
}
