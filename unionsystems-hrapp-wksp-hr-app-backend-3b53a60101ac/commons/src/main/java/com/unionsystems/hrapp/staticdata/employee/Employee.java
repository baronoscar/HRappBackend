package com.unionsystems.hrapp.staticdata.employee;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.unionsystems.hrapp.salaryadvance.SalaryAdvancePaymentStatus;
import com.unionsystems.hrapp.staticdata.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
@EqualsAndHashCode(callSuper = true)
@Data
public class Employee extends BaseEntity {
    @NotBlank @Column()
    private String companyRole;
    private String payeeType;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String photoPath;
    private BigDecimal salary;
    @Column(nullable = true)
    private LocalDate lastPay;
    @Column(nullable = true)
    private LocalDate nextPay;
    @Enumerated
    private EmployeeSalaryStatus status;


}
