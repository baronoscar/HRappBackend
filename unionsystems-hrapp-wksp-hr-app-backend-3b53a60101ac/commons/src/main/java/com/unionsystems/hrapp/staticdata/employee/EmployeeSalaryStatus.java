package com.unionsystems.hrapp.staticdata.employee;

public enum EmployeeSalaryStatus {

    PAID ("Paid"),
    PENDING("Pending"),
    DISAPPROVED("Disapproved");

    private final String name;

    EmployeeSalaryStatus(String name) {
        this.name = name;
    }
}
