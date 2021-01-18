/**
 * static keyword means that there only one copy available of the variable
 * or the method or the nested class
 * 
 * 1. variables
 *  static variable is used to define a common property shared by all the
 *  objects of that class.
 *  Any uninitialized static variable is initialized to zero by default.
 * 2. methods
 *  static methods belong to class, not the object.
 *  static methods can be called using the class name
 *  static method can access static variables and alter them
 * 3. nested classes
 * 4. block:
 *   static block is used to initialize static variables
 *   static block is executed before the main method
 * 
 * Rules:
 * 1. static variable can be accessed only inside a static method
 * 2. anything static can be accessed using the class name
 * 
 * Access specifiers -> levels of access
 * 1. Public -> available to the entire project
 * 2. Default -> available in the same package only
 * 3. Protected -> available in the same class and in the child class
 * 4. Private -> available in the same
 */

package com.hexaware.mysampleproject.staticspack;

public class Employee {
  private int empId;
  private String empName;
  //static String organization = "Hexaware";
  public static String organization;

  public Employee() {

  }

  public Employee(int argEmpId, String argEmpName) {
    this.empId = argEmpId;
    this.empName = argEmpName;
  }

  public static void changeOrg(String newOrg) {
    organization = newOrg;
  }

  public int getEmpId() {
    return this.empId;
  }

  public String getEmpName() {
    return this.empName;
  }

  public void setEmpId(int argEmpId) {
    this.empId = argEmpId;
  }

  public void setEmpName(String argEmpName){
    this.empName = argEmpName;
  }
 
  public void show() {
    System.out.println("Id: " + getEmpId() + " Name: " + getEmpName()
        + " Organization: " + organization);
  } 
}
