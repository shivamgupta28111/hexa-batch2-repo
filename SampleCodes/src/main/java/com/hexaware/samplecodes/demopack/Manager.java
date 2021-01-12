/**
 * when one class gets the properties of another class -> inheritance
 * 
 * All public properties and methods of the base class get inherited. Constructor is NOT included
 * All private properties and methods of the base class are NOT inherited.
 * All protected properties and methods of the base class are inherited as if they are public
 */

package com.hexaware.samplecodes.demopack;

public class Manager extends Employee {
    public Manager() {
        this.sal = 0.0;
    }
}
