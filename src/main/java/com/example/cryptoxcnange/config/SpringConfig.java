package com.example.cryptoxcnange.config;

import com.example.cryptoxcnange.util.DTOUserConverter;
import exchangeTransactions.PriceSetter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.cryptoxcnange")
public class SpringConfig {

    @Bean
    public PriceSetter getPriceSetter(){
        return new PriceSetter();
    }

    @Bean
    public DTOUserConverter getDTOUserConverter(){
        return new DTOUserConverter();
    }
}
