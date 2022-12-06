package org.ibs.service.bussines;

import org.ibs.service.domain.entity.Employee;
import org.slf4j.Logger;

public class GreetingsServiceImpl implements GreetingsService {

    private Logger log;

    public GreetingsServiceImpl(Logger log) {
        this.log = log;
    }

    @Override
    public void seyHello(Employee employee){
        log.info("Hello " + employee.getFirstName());
    }
}
