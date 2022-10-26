package edu.miu.cs425.onlineshoppingapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication//
public class OnlineShoppingappApplication  {

    public static void main(String[] args) {
        SpringApplication.run(OnlineShoppingappApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
