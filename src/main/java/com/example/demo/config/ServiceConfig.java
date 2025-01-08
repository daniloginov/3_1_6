package com.example.demo.config;

import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public UserService service() {
        return new UserServiceImpl();
    }
}