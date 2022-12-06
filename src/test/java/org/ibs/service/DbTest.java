package org.ibs.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.ibs.service.domain.entity.Departament;
import org.ibs.service.domain.entity.Employee;
import org.ibs.service.domain.entity.EmployeeRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
public class DbTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    EmployeeRepository employeeRepository;

    @BeforeEach
    void setup() {
    /**
        department = new Departament(null, "IT");
        Course course = new Course(null, "Rest service");
        Employee employee = new Employee(null, "a", "b", LocalDate.now(), department, 500000, List.of(course));

        em.persist(department);
        em.persist(course);
        em.persist(employee);
    */
    }

    @Test
    void test(){
        Assert.assertEquals(2, em.createQuery("select departament FROM Departament departament").getResultList().size());
        Employee emp = em.createQuery("SELECT em FROM Employee em", Employee.class).setMaxResults(1).getResultList().get(0);

        Assert.assertEquals("Rest service", emp.getCourse().get(0).getName());
    }

    @Test
    void test2(){
        Employee emp = employeeRepository.findByFirstName("a").get(0);
        Assert.assertEquals(3, (long) emp.getId());
        Assert.assertEquals(3, (long)emp.getMonthSalary());
    }

}
