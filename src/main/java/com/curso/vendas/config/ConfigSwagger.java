package com.curso.vendas.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class ConfigSwagger {
    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Vendas Aplicattion ")
                        .contact(contact())
                        .description("Projeto de Vendas Para Aprendizado Do Spring ")
                        .version("1.0.0"));
    }
    private Contact contact() {
        return new Contact().name("Rian Erick").url("https://linkedin.com/in/rianerick");
    }

}