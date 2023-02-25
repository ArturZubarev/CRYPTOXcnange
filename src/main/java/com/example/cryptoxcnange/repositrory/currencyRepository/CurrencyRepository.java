package com.example.cryptoxcnange.repositrory.currencyRepository;

import com.example.cryptoxcnange.model.currency.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Long> {

    public Optional<Currency> findCurrencyByName(String name);






}
