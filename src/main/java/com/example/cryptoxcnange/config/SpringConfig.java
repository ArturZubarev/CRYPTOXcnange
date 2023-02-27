package com.example.cryptoxcnange.config;

import com.example.cryptoxcnange.dto.admin.AdminDTO;
import com.example.cryptoxcnange.dto.user.DTOUserConverter;
import org.modelmapper.ModelMapper;
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

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}
