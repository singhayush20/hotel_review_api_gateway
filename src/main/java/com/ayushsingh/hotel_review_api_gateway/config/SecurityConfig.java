package com.ayushsingh.hotel_review_api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity  //we are using webflux (because of spring cloud, therefore we should use @EnableWebFluxSecurity and not @EnableSpringSecurity)
public class SecurityConfig {
    //Create a security filter chain for webflux
    //https://docs.spring.io/spring-security/reference/reactive/configuration/webflux.html
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity){
        httpSecurity
        .authorizeExchange() //authorize requests
        .anyExchange() //any exchange
        .authenticated() //should be authenticated
        .and()
        .oauth2Client() //configure oauth2 login
        .and()
        .oauth2ResourceServer()
        .jwt();
    return httpSecurity.build();
    }
}
