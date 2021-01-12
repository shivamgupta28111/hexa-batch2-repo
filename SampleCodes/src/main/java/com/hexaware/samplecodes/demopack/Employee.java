package com.hexaware.samplecodes.demopack;

public class Employee {
  private int empId;
  private String empName;
  protected double sal; //=> private double sal
  //private JobTitles jobTitle;

  public Employee(){
    this.empId = 0;
    this.empName = null;
    this.sal = 0.0;
  }

  public Employee(int argEmpId, String argEmpName, double argSal){//, JobTitles jTitles) {
    this.empId = argEmpId;
    this.empName = argEmpName;
    this.sal = argSal;
    //this.jobTitle = jTitles;
  }

  public int getEmpId() {
    return this.empId;
  }

  public void setEmpId(int empId) {
    this.empId = empId;
  }

  public String getEmpName() {
    return this.empName;
  }

  public void setEmpName(String empName) {
    this.empName = empName;
  }

  public double getSal() {
    return this.sal;
  }

  public void setSal(double sal) {
    this.sal = sal;
  }

  // public JobTitles getJobTitle() {
  //   return this.jobTitle;
  // }

  // public void setJobTitle(JobTitles jobTitle) {
  //   this.jobTitle = jobTitle;
  // }
}
