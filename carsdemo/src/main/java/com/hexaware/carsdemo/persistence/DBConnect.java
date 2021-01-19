package com.hexaware.carsdemo.persistence;

import org.skife.jdbi.v2.DBI;

public class DBConnect {
  public DBI getConnection() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      String dbc = System.getenv("DB_CONNECTION");
      if (dbc == null || dbc.equals("")){
        dbc = "localhost:3306";
      }
      DBI dbi = new DBI("jdbc:mysql://" + dbc + "/carsdemo?useSSL=false", "root", "root");
      return dbi;
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
