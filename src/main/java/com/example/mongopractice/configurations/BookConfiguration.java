package com.example.mongopractice.configurations;

import com.example.mongopractice.models.factories.BookFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class BookConfiguration {
        @Bean
        public BookFactory booksDtoFactory() {
            return new BookFactory();
        }
    }
