package com.test.springcoredemo.config;

import com.test.springcoredemo.common.Coach;
import com.test.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aqua")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
