package org.ibs.service.rest.v1;

import lombok.extern.slf4j.Slf4j;
import org.ibs.service.domain.entity.Employee;
import org.ibs.service.domain.entity.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    Iterable<Employee> getAll(){return repository.findAll();
    }

    //@ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Employee newEmployee(@RequestBody Employee employee){
        log.info("--------------------------------------------------");
        if (employee.getId() != null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Должен быть айдишник");
        return repository.save(employee);
    }

    @GetMapping("/{id}")
    Employee getEmployee(@PathVariable Long id){
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id){
        repository.deleteById(id);
    }
}
