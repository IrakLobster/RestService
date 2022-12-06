package org.ibs.service.bussines;

import org.ibs.service.domain.entity.Departament;
import org.ibs.service.domain.entity.DepartamentRepository;

import org.ibs.service.dto.Employee;
import org.ibs.service.dto.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalaryService {

    @Autowired
    private DepartamentRepository repository;

    @Autowired
    private EmployeeMapper mapper;

    public Optional<Employee> maxSalaryEmployeeInDepartament(Long departamentId){
        Optional<Departament> departamentOptional = repository.findById(departamentId);
        if(departamentOptional.isEmpty() || departamentOptional.get().getEmployees().isEmpty()){
            return Optional.empty();
        }

        org.ibs.service.domain.entity.Employee employee = departamentOptional.get().getEmployees().stream().max((e1, e2) -> e1.getMonthSalary().compareTo(e2.getMonthSalary())).get();
        return Optional.of(mapper.toDto(employee));
    }
}
