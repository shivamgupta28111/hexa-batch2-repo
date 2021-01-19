package com.hexaware.carsdemo.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.carsdemo.model.Cars;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class CarsMapper implements ResultSetMapper<Cars>{
    
  public Cars map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
    return new Cars(rs.getInt("ID"), rs.getString("NAME"), rs.getDouble("PRICE"));
  }
}
