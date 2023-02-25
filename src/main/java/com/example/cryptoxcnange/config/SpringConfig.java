package com.example.cryptoxcnange.config;

import exchangeTransactions.PriceSetter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public PriceSetter getPriceSetter(){
        return new PriceSetter();
    }
}
