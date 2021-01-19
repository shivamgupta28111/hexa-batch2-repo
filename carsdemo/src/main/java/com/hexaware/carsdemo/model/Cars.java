package com.hexaware.carsdemo.model;

public class Cars {
  private int carId;
  private String carName;
  private double price;

  public int getCarId() {
    return carId;
  }

  public void setCarId(int argCarId) {
    this.carId = argCarId;
  }

  public String getCarName() {
    return carName;
  }

  public void setCarName(String argCarName) {
    this.carName = argCarName;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double argPrice) {
    this.price = argPrice;
  }

  public Cars() {

  }

  public Cars(int argCarId, String argCarName, double argPrice) {
    this.carId = argCarId;
    this.carName = argCarName;
    this.price = argPrice;
  }
}