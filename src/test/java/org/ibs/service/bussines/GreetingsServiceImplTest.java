package org.ibs.service.bussines;

import org.ibs.service.domain.entity.Employee;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class GreetingsServiceImplTest {

    @Autowired
    GreetingsService gs;

    @Autowired
    Employee employee;

    @Test
    void seyHello() {
        gs.seyHello(employee);
    }
}