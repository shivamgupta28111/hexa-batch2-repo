package com.hexaware.carsdemo.persistence;

import java.util.List;

import com.hexaware.carsdemo.model.Cars;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface CarsDAO {
  @SqlQuery("SELECT * FROM CARS")
  @Mapper(CarsMapper.class)
  List<Cars> showAllCars();

  @SqlQuery("SELECT * FROM CARS WHERE ID = :carId")
  @Mapper(CarsMapper.class)
  Cars findById(@Bind("carId") final int carId);

  @SqlUpdate("INSERT INTO CARS VALUES (:carId, :carName, :price)")
  int insertNewCar(@Bind("carId") final int carId, @Bind("carName") final String carName,
      @Bind("price") final double price);
}
