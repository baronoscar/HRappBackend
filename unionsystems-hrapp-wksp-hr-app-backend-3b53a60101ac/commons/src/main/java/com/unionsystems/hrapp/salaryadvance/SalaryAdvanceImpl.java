package com.unionsystems.hrapp.salaryadvance;

import com.unionsystems.hrapp.exception.DataNotFoundException;
import com.unionsystems.hrapp.staticdata.employee.Employee;
import com.unionsystems.hrapp.staticdata.employee.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SalaryAdvanceImpl {
    @Autowired
    private SalaryAdvanceRepository salaryAdvanceRepository;

    public List<SalaryAdvance> getAllSalaryAdvance(){
        return salaryAdvanceRepository.findAll(Sort.by(Sort.Order.asc("firstName")));
    }

/*
    public Employee getEmployeeByStaffNo(String staffNo) {
        return employeeRepository.getEmployeeByStaffNo(staffNo);
    }
*/

    public SalaryAdvance getSalaryAdvanceByID(Long id){
        return salaryAdvanceRepository.findById(id).orElseThrow(() -> new DataNotFoundException(String.format("%d NOT found", id)));
    }

    public SalaryAdvance saveSalaryAdvance(SalaryAdvance salaryAdvance){
//        return employeeRepository.save(employee);
        salaryAdvance.setStatus(SalaryAdvancePaymentStatus.PENDING);
        SalaryAdvance e = salaryAdvanceRepository.save(salaryAdvance);
        System.out.println(e.getId());
        return e;
    }

    public void deleteSalaryAdvance(Long id) {
        SalaryAdvance salaryAdvance = getSalaryAdvanceByID(id);
        salaryAdvanceRepository.delete(salaryAdvance);
    }

    public SalaryAdvance updateSalaryAdvance(SalaryAdvance salaryAdvance) {
        SalaryAdvance e = getSalaryAdvanceByID(salaryAdvance.getId());
        e.setFirstName(salaryAdvance.getFirstName());
        e.setLastName(salaryAdvance.getLastName());
        e.setCompanyRole(salaryAdvance.getCompanyRole());
        e.setAmount(salaryAdvance.getAmount());
        e.setReasonForSalaryAdvance(salaryAdvance.getReasonForSalaryAdvance());
        e.setRepaymentPlanType(salaryAdvance.getRepaymentPlanType());
        e.setStatus(salaryAdvance.getStatus());
        return salaryAdvanceRepository.save(e);
    }

    public SalaryAdvance approve(Long id) {
        SalaryAdvance advance = getSalaryAdvanceByID(id);
        advance.setStatus(SalaryAdvancePaymentStatus.APPROVED);
        return salaryAdvanceRepository.save(advance);
    }

    public SalaryAdvance rejected(Long id) {
        SalaryAdvance advance = getSalaryAdvanceByID(id);
        advance.setStatus(SalaryAdvancePaymentStatus.REJECTED);
        System.out.println("rejected impl");
        System.out.println(advance);
        return salaryAdvanceRepository.save(advance);
    }

}
