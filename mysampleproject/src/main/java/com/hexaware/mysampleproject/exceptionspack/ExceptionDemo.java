/**
 * Exception are runtime errors
 *  -> abnormal conditions which stop a program from completing successfully
 * 
 * Exception handling -> mechanism for handling exceptions
 * 
 * Problems which cannot be handled through exception handling -> Errors
 * 
 * Base class for all exceptions and errors -> Throwable
 * 
 * Base class of all exceptions -> Exception
 * 
 * keywords -> try, catch, finally, throw and throws
 * 
 * try block -> add all the statements that could throw an exception here
 * catch block -> handles the exceptions
 * finally block -> is executed whether there is an exception or not
 * 
 * every try should have 1 catch or 1 finally (at least) mandatorily.
 * 
 * You can write more than 1 catch.
 * 
 * Exceptions belong in the java.lang package
 * 
 * Categories:
 * 1. Checked Exceptions -> compile time exceptions
 * 2. Unchecked Exceptions -> run - time exceptions
 * 
 * List of Exception:
 * 1. IOException
 * 2. SQLException
 * 3. ArithmeticException
 * 4. ArrayOutOfBoundsException
 * 5. StringIndexOutOfBoundsException
 * 6. ClassNotFoundException
 * 7. NullPointerException
 * 8. NumberFormatException
 * 9. ParseException
 * 
 * 
 * throws is used to declare that an exception can get thrown
 * 
 * throw generates the exception
 */

package com.hexaware.mysampleproject.exceptionspack;

public class ExceptionDemo {
  public static int divide(int a, int b){// throws ArithmeticException, NullPointerException {
    int val = 0;
    if(a > 0 && b > 0){
       val = a/b;
    } else {
      throw new ArithmeticException();
    }
    return val;
  }
}
