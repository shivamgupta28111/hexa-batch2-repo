/**
 * an abstract class cannot be instantiated
 * can have both concrete methods and abstract methods
 */

package com.hexaware.mysampleproject.demopack;

public abstract class Animal {
    private int animalId;
    private String animalType;

    public int getAnimalId() {
        return this.animalId;
    }

    public String getAnimalType() {
        return this.animalType;
    }

    public void setAnimalId(int argId) {
        this.animalId = argId;
    }

    public void setAnimalType(String argType) {
        this.animalType = argType;
    }

    public void speak() {
        System.out.println("Animal Speaks");
    }

     public abstract void eat();
}
