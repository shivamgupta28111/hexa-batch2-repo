/**
 * number1, number2
 * 
 * add(number1, number2)
 * subtract(number1,number2)
 * multiply(number1,number2)
 * divide(number1, number2) => check if number2 is zero
 */

package com.hexaware.mysampleproject.demopack;

public class Calculator {
  private int number1;
  private int number2;

  public int getNumber1() {
    return number1;
  }

  public void setNumber1(int argNumber1) {
    this.number1 = argNumber1;
  }

  public int getNumber2() {
    return number2;
  }

  public void setNumber2(int argNumber2) {
    this.number2 = argNumber2;
  }

  public int add(int num1, int num2) {
    return num1 + num2;
  }

  public int add(int num1, int num2, int num3){
    return num1 + num2 + num3;
  }
  
  public int sub(int num1, int num2) {
    return num1 + num2;
  }
  
}
