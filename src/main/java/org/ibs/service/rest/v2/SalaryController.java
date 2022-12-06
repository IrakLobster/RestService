package org.ibs.service.rest.v2;

import io.swagger.v3.oas.annotations.Operation;
import org.ibs.service.bussines.SalaryService;

import org.ibs.service.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v2/salary/")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @GetMapping("/max/departament/{departamentId}")
    @Operation(operationId = "maxSalaryEmployeeInDep", summary = "Get max saalry employee")
    Employee maxSalaryEmployeeInDepartament(@PathVariable Long departamentId){
        return salaryService.maxSalaryEmployeeInDepartament(departamentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Departament or employee not found"));
    }
}
