package com.unionsystems.hrapp.salaryadvance;

import com.unionsystems.hrapp.staticdata.employee.Employee;
import com.unionsystems.hrapp.staticdata.employee.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/salary-advance")
@CrossOrigin(origins="*", allowedHeaders = "*")
@Slf4j
public class SalaryAdvanceController {
    @Autowired
    private SalaryAdvanceImpl salaryAdvanceService;

    @GetMapping
    public List<SalaryAdvance> getAllSalaryAdvance(){
        return salaryAdvanceService.getAllSalaryAdvance();
    }

    @GetMapping("/{id}")
    public SalaryAdvance getById(@PathVariable("id") Long id){
        return salaryAdvanceService.getSalaryAdvanceByID(id);
    }

    @GetMapping("/approve/{id}")
    public SalaryAdvance approve(@PathVariable("id") Long id){
        return salaryAdvanceService.approve(id);
    }
    @GetMapping("/rejected/{id}")
    public SalaryAdvance rejected(@PathVariable("id") Long id){
        return salaryAdvanceService.rejected(id);
    }

    @PostMapping
    public SalaryAdvance save(@Valid @RequestBody SalaryAdvance salaryAdvance){
        System.out.println(salaryAdvance.getFirstName());
        return salaryAdvanceService.saveSalaryAdvance(salaryAdvance);
    }
    @PostMapping("/edit")
    public SalaryAdvance update(@Valid @RequestBody SalaryAdvance salaryAdvance){
        System.out.println(salaryAdvance.getFirstName());
        return salaryAdvanceService.updateSalaryAdvance(salaryAdvance);
    }

    @DeleteMapping( "/delete/{id}")
    public void deleteSalaryAdvance(@PathVariable("id") Long id) {
        salaryAdvanceService.deleteSalaryAdvance(id);
    }

}
