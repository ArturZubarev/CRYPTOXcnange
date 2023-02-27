package com.example.cryptoxcnange.config;

import com.example.cryptoxcnange.business.PriceSetter;
import com.example.cryptoxcnange.dto.AdminDTO;
import com.example.cryptoxcnange.util.DTOUserConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.cryptoxcnange")
public class SpringConfig {



    @Bean
    public DTOUserConverter getDTOUserConverter(){
        return new DTOUserConverter();
    }

    @Bean
    public AdminDTO getAdminDTO(){
        return new AdminDTO();
    }

}
