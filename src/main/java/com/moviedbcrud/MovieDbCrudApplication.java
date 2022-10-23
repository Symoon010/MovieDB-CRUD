package com.moviedbcrud;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

@SpringBootApplication
@EnableJpaRepositories
public class MovieDbCrudApplication {


    @Bean
    public SpringDataDialect springDataDialect() {
        return new SpringDataDialect();
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    public static void main(String[] args) {
        SpringApplication.run(MovieDbCrudApplication.class, args);
    }

}
