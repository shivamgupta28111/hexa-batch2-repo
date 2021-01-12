/**
 * String is a sequence of characters
 * 
 * character -> 'c'
 * String -> "c"
 * 
 * String is a predefined class in Java.
 * Any String variable is an object of the String class.
 * 
 * Strings are immutable
 */

package com.hexaware.samplecodes.demopack;

public class StringsDemo {
  
  public void forStrings() {
    //int testVar = 0;
    String str = "This is a string";
    str = "this is another string";
    int len = str.length();
    System.out.println("Length: " + len);

    String str1 = new String("Java");
    String str2 = "Programming";

    String concatedStr = str1.concat(str2);
    System.out.println(concatedStr);

    boolean res = str1.equals(str2);
    System.out.println(res);

    char c = str1.charAt(0);
    System.out.println(c);

    System.out.println(str1.toLowerCase());
  }
}
