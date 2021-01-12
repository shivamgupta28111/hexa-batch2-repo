/**
 * Operators
 * 1. Functional
 *     Arithmetic, Assignment, Relational, Logical, Bitwise
 * 2. Based on number of operands
 *    unary, binary and ternary
 * 
 * Arithmetic:
 *   +, -, *, /, %
 * 
 * Assignment
 *   =
 * 
 * Relational
 *   > < >= <= != ==
 * 
 * Logical 
 *    &&  ||  !
 * 
 * 
 * Unary -> 1 operand
 *  ++ ->Incrementation 
 *  -- -> decrementation 
 * (Ex: a++, ++a)
 * 
 * Binary -> 2 operands
 *  +, -, *, /, %, >, < etc.
 *  EX: a + b
 * 
 * ternary -> 3 operands
 * ?:
 * Ex: a>b ? true : false
 * 
 * Control Statements
 * 1. Iterative -> for, do while, while
 * 2. non - iterative -> if, if-else, switch case
 * 
 * -> if(condition){statements;}
 * -> if(condition){statements;} else {statements;}
 * -> if(condition) {statements;} else if(condition) {statements;} ...
 * 
 * -> switch (variable) {
 *    case 1: statements;
 *      break;
 *      ......
 *    default:
 *      break;
 *  }
 * 
 * -> for (initialization; condition; incrementation/decrementation){statements;}
 * -> while (condition) { increment/decrement}
 * -> do {statements} while(condition);
 * 
 * Jump statements:
 *  break, continue, goto
 * 
 * Arrays: is a collection of similar elements arranged sequentially and continuously in memory
 * In Java arrays are objects
 *  datatype[] arr;
 *  datatype []arr;
 *  datatype arr[];
 * Ex to declare an array
 * int[] arr;
 * 
 * Ex to define an array
 *  arr = new int[4];
 *  arr = {12,23,34,56}; 
 * 
 * Arrays are indexed. 
 * 
 * 
 * Method -> define a functionality. a block of code which performs some task
 * reusability of code
 * access_specifier return_type method_name(parameter_list)
 * 
 * Types of methods:
 * 1. pre-defined
 * 2. user defined
 */


package com.hexaware.samplecodes.demopack;


public class Tutorial080121 {

  int size = 5;

  public int addNumbers(int num1, int num2) {
  //  int num1 = 5, num2 = 7;
    return num1 + num2;
  }

  public void arrayDemo(){
    int[] arr = new int[size];

    int[] arr1 = {2, 12, 34, 45};

    //Initialization
    //method 1
    arr1[0] = 12;
    arr1[1] = 24;


    //method 2
    for(int i = 0; i < 5; i++) {
      arr[i] = i + 1;
    }

    //to read from an array
    // for(int i = 0; i < arr.length; i++) {
    //   System.out.println(arr[i]);
    // }

    for(int i: arr){
      System.out.println(i);
    }
  }

  public void operatorsDemo(){
    int var1, var2, result;
    var1 = 10;
    var2 = 20;

    result = var1 + var2;
    System.out.println(result);
    System.out.println(var1 > var2 ? "Var1 is greater" : "var2 is greater" );
  }

  public void controlStatementsDemo() {
    int counter = 1;
    // while(counter <= 10) {
    //   System.out.println(counter * 2);
    //   counter++;
    // }

    do {
      System.out.println(counter * 2);
      counter++;
      //break;
    } while(counter>10);

    // for(int i = 0; i < 10; i++) {
    //   System.out.println(i * 2);
    // }

    // for(;;){
    //   System.out.println("In loop");
    //   break;
    // }

    // int var1 = 10, var2 = 20;

    // if(var1 > 10) {
    //   if(var2 > 20){
    //     System.out.println("All good");
    //   }
    // }

    // for(int i = 1; i <= 10; i++) {// i = 2
    //   for(int j = 1; j <= 10; j++){
    //     System.out.print(i * j + " ");  //1, 2, ..... 10
    //   }
    //   System.out.println();
    // }

    //int age = 18;
    //String city = "Bangalore";

    // if (age > 30) 
    //   System.out.println("Age greater than 20");
    // else if(age > 20)
    //   System.out.println("Age greater than 20");
    // else if( age > 10)
    //   System.out.println("age greater than 10");
    // else
    //   System.out.println("age is less than 10");

    // switch (age) {
    //   case 30: System.out.println("Age greater than 30");
    //     break;
    //   case 20: System.out.println("Age greater than 20");
    //     break;
    //   case 10: System.out.println("Age greater than 10");
    //     break;
    //   default: System.out.println("Age does not fall into any category");
    //     break;
    // }

    // switch(city) {
    //   case "Bangalore": System.out.println("You are in Bangalore");
    //     break;
    //   case "Mumbai": System.out.println("you are in Mumbai");
    //     break;
    //   case "Delhi": System.out.println("You are in Delhi");
    //     break;
    //   default: System.out.println("No city mentioned");
    //     break;
    // }

    
  }

  public void fibonacciExample() {
    int number1 = 0, number2 = 1, sum, count = 10;

    System.out.print(number1 + " " + number2); //0 1

    for(int i = number2; i <= count; ++i) {
      sum = number1 + number2;
      System.out.print(" " + sum); 
      number1 = number2;
      number2 = sum;
    }
  }


}