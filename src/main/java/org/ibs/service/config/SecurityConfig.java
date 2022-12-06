package org.ibs.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


public class SecurityConfig {
/**
    public SecurityFilterChain configure(HttpSecurity http){
        http
                .authorizeHttpRequests()
                    .anyRequest("/**").hasRole("READER")
                    .anyRequest(HttpMethod.DELETE, "/v2/employees").hasRole("WRITER")
                    .anyRequest(HttpMethod.POST, "/v2/employees").hasRole("WRITER")
                    .and()
                .formLogin()
                .defaultSuccessUrl("");
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails userR = User.withDefaultPasswordEncoder().username("reader").password("123").roles("READER").build();
        UserDetails userW = User.withDefaultPasswordEncoder().username("writer").password("123").roles("WRITER","READER").build();

        return new InMemoryUserDetailsManager(userR, userW);
    };
    */
}
