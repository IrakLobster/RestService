package org.ibs.service.config;

import lombok.extern.slf4j.Slf4j;
import org.ibs.service.bussines.GreetingsService;
import org.ibs.service.bussines.GreetingsServiceImpl;
import org.ibs.service.domain.entity.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class GreetingsServiceConfig {

    @Bean
    GreetingsService getGSImpl(){
        return new GreetingsServiceImpl(log);
    }

    @Bean
    Employee makeDefEmployee(){
        return new Employee(null, "Славка", null, null, null, null, null, null);
    }
}
