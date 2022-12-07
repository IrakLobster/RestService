package org.ibs.service.bussines;


import jakarta.persistence.Column;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.ibs.service.domain.entity.Employee;
import org.ibs.service.domain.entity.EmployeeRepository;
import org.ibs.service.dto.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BossService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeMapper mapper;

    @PersistenceContext
    EntityManager em;

    public Employee getBoss(Long epmloyeeId){
        List<Employee> getBoss = repository.findByBoss(repository.findById(epmloyeeId).get().getBoss());
        return getBoss.get(0).getBoss();
    }

    public List<Employee> getEmployee(Long bossId){
        List<Employee> employee = em.createQuery("SELECT employee FROM Employee employee WHERE employee.boss.id = :idBoss").setParameter("idBoss", bossId).getResultList();
        return employee;
    }

    public List<Employee> salaryService(){
        List<Employee> employees = em.createQuery("SELECT employee FROM Employee employee WHERE employee.monthSalary > employee.boss.monthSalary").getResultList();
        return employees;
    }

}
