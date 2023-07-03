package br.edu.atitus.trabalhopoo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
      .info(new Info().title("Documentação Trabalho Final POO ").description("Descrição")
        .contact(new Contact().name("Desenvolvedor Junior").email("a.h.vasoler@gmail.com"))
        .version("version 01"));
  }
}
