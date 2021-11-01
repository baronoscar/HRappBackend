package com.unionsystems.hrapp.salaryadvance;

import com.unionsystems.hrapp.staticdata.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "salaryAdvance")

@EqualsAndHashCode(callSuper = true)
@Data
public class SalaryAdvance extends BaseEntity {
    @NotBlank @Column()
    @NotNull
    @NotNull
    private String repaymentPlanType;
    @Enumerated(EnumType.STRING)
    private SalaryAdvancePaymentStatus status;
    private BigDecimal amount;
    private String firstName;
    private String lastName;
    private String companyRole;
    private String reasonForSalaryAdvance;
    private Date paymentDueDate;

}
