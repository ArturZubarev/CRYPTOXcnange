package com.example.cryptoxcnange.repositroty.traderRepository;


import com.example.cryptoxcnange.model.role.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TraderRepository extends JpaRepository<Trader, Long> {
    Optional<Trader> getTraderById(int id);


}
