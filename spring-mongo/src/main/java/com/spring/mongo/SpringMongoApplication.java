package com.spring.mongo;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMongoApplication {

    public static void main(String[] args) {

		SpringApplication.run(SpringMongoApplication.class, args);
    }
    @Bean
    public OpenAPI openAPI(){
        Info info = new Info().description("Spring Mongo Application");
        return new OpenAPI().info(info);
    }

}
