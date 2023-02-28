package com.example.cryptoxcnange.repositrory.currencyRepository;

import com.example.cryptoxcnange.model.currency.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Long> {

    public Currency findCurrencyByName(String name);






}
