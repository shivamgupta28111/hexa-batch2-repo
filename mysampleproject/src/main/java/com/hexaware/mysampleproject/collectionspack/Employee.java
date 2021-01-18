package com.hexaware.mysampleproject.collectionspack;

public class Employee {
    private int empId;
    private String empName;

    public int getEmpId() {
        return this.empId;
    }

    public String getEmpName() {
        return this.empName;
    }

    public void setEmpId(int argEmpId) {
        this.empId = argEmpId;
    }

    public void setEmpName(String argEmpName) {
        this.empName = argEmpName;
    }

    public Employee() {

    }

    public Employee(int argEmpId, String argEmpName) {
        this.empId = argEmpId;
        this.empName = argEmpName;
    }
}