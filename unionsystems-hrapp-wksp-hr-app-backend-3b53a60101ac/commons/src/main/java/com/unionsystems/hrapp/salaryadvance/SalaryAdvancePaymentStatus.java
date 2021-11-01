package com.unionsystems.hrapp.salaryadvance;

public enum SalaryAdvancePaymentStatus {
    PENDING ("Pending"),
    APPROVED("Approved"),
    REJECTED("Rejected");

    private final String name;

    SalaryAdvancePaymentStatus(String name) {
        this.name = name;
    }
}
