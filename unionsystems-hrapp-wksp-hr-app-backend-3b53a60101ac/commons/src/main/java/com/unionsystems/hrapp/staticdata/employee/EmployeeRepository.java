package com.unionsystems.hrapp.staticdata.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    Employee getEmployeeByStaffNo(String staffNo);

}
