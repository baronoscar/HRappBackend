package com.unionsystems.hrapp.staticdata.employee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins="*", allowedHeaders = "*")
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") Long id){
        return employeeService.getEmployeeByID(id);
    }

    @PostMapping
    public Employee save(@Valid @RequestBody Employee employee){
        System.out.println(employee.getFirstName());
        return employeeService.saveEmployee(employee);
    }
    @PostMapping("/edit")
    public Employee update(@Valid @RequestBody Employee employee){
        System.out.println(employee.getFirstName());
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping( "/delete/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }

}
