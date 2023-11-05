package com.example.mongopractice.configurations;


import com.example.mongopractice.models.factories.ReaderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ReaderConfiguration {
    @Bean
    public ReaderFactory readersDtoFactory() {
        return new ReaderFactory();
    }
}
