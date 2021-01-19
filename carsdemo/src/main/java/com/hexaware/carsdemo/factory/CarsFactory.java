package com.hexaware.carsdemo.factory;

import java.util.List;

import com.hexaware.carsdemo.model.Cars;
import com.hexaware.carsdemo.persistence.CarsDAO;
import com.hexaware.carsdemo.persistence.DBConnect;


public class CarsFactory {
  protected CarsFactory() {

  }

  private static CarsDAO dao() {
    DBConnect db = new DBConnect();
    return db.getConnection().onDemand(CarsDAO.class);
  }

  public static Cars[] showCars() {
    List<Cars> cars = dao().showAllCars();
    return cars.toArray(new Cars[cars.size()]);
  }

  public static Cars retrieveCarDetails(final int argCarId) {
    Cars car = dao().findById(argCarId);
    return car;
  }

  public static String addNewCar(final int argCarId, final String argCarName, final double argPrice) {
    String msg = "Unable to add new Car";

    int res = dao().insertNewCar(argCarId, argCarName, argPrice);
    if(res > 0) {
      msg = "Car added Successfully";
    }
    return msg;
  }
}
