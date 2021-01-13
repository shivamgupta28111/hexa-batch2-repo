/**
 * Properties:-
 * student id -> number (int)
 * student name -> string 
 * age -> number (int)
 * course id -> number (int)
 * 
 * Methods:-
 * addStudent
 * updateStudent
 * deleteStudent
 * displayAllStudents
 * displayStudentDetails
 */


package com.hexaware.mysampleproject.demopack;

public class Student {
  private int studentId;
  private String studentName;
  private int studentAge;
  private int courseId;

  public int getStudentId() {
    return this.studentId;
  }

  public void setStudentId(int argStudentId) {
    this.studentId = argStudentId;
  }

  public String getStudentName() {
    return this.studentName;
  }

  public void setStudentName(String argStudentName) {
    this.studentName = argStudentName;
  }

  public int getStudentAge() {
    return this.studentAge;
  }

  public void setStudentAge(int argStudentAge) {
    this.studentAge = argStudentAge;
  }

  public int getCourseId() {
    return this.courseId;
  }

  public void setCourseId(int argCourseId) {
    this.courseId = argCourseId;
  }

  public Student() {

  }

  public Student(int argStudentId, String argStudentName, int argAge, int argCourseId) {
    this.studentId = argStudentId;
    this.studentName = argStudentName;
    this.studentAge = argAge;
    this.courseId = argCourseId;
  }
}
