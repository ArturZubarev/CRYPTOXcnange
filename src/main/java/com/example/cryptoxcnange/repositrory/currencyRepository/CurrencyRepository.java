package com.example.cryptoxcnange.repositrory.currencyRepository;

import com.example.cryptoxcnange.model.currency.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency,Long> {

}
