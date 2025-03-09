package com.demoapringboot.springbasic.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    //factory method
    @Bean
    public ModelMapper getModelMapper()
    {
        return new ModelMapper();
    }



}
