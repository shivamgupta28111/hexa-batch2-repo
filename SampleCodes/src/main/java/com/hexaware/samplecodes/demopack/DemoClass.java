/**
 * javadoc comment
 */
/*
  multi - line comment
*/
// single - line comment

/**
 * Datatypes -> type of data stored
 * 1. primitive
 *     int, char, short, long, byte, float, double, boolean 
 * 2. non - primitive
 *     classes, interfaces, enum, arrays
 * 
 * variable -> named location in memory which stores a datatype
 * Types of variables:
 * 1. local variable
 * 2. instance variable
 * 3. static variable
 * 
 * access_specifier datatype variable_name [= value];
 */

package com.hexaware.samplecodes.demopack;

/**
 * class to demonstrate the basics of Java.
 */
public class DemoClass {
    public int demoId;
    private String demoName;

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String argDemo) {
        demoName = argDemo;
    }
}
