package com.unionsystems.hrapp.staticdata.employee;

import com.unionsystems.hrapp.exception.DataNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll(Sort.by(Sort.Order.asc("firstName")));
    }

/*
    public Employee getEmployeeByStaffNo(String staffNo) {
        return employeeRepository.getEmployeeByStaffNo(staffNo);
    }
*/

    public Employee getEmployeeByID(Long id){
        return employeeRepository.findById(id).orElseThrow(() -> new DataNotFoundException(String.format("%d NOT found", id)));
    }

    public Employee saveEmployee(Employee employee){
//        return employeeRepository.save(employee);
        Employee e = employeeRepository.save(employee);
        System.out.println(e.getId());
        return e;
    }

    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeByID(id);
        employeeRepository.delete(employee);
    }

    public Employee updateEmployee(Employee employee) {
        Employee e = getEmployeeByID(employee.getId());
        e.setFirstName(employee.getFirstName());
        e.setLastName(employee.getLastName());
        e.setCompanyRole(employee.getCompanyRole());
        e.setLastPay(employee.getLastPay());
        e.setNextPay(employee.getNextPay());
        e.setSalary(employee.getSalary());
        e.setPayeeType(employee.getPayeeType());
        return employeeRepository.save(e);
    }
}
