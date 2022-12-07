package org.ibs.service.rest.v2;


import io.swagger.v3.oas.annotations.Operation;
import org.ibs.service.bussines.BossService;
import org.ibs.service.domain.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v2/boss/")
public class BossController {

    @Autowired
    private BossService bossService;

    @GetMapping("/boss/{eployeeId}")
    @Operation(operationId = "maxSalaryEmployeeInDep", summary = "Get max saalry employee")
    Employee getBoss(@PathVariable Long eployeeId){
        Employee boss = bossService.getBoss(eployeeId);
        return boss;
    }

    @GetMapping("/boss/boss1/{bossId}")
    List<Employee> getEmployee(@PathVariable Long bossId){
        return bossService.getEmployee(bossId);
    }

    @GetMapping("/boss/salaryService")
    List<Employee> getSalary(){
        return bossService.salaryService();
    }
}
