/**
 * JDBC -> Java DataBase Connectivity
 * JDBC API (Application Programming Interface)
 * 
 * Drivers -> software that creates the connection between the app and the db
 * 
 * 1. connect to the db
 * 2. execute the queries and statements
 * 3. retrieve the contents from database
 * 
 * Step 1: connect to the db
 *   Driver: com.mysql.jdbc.Driver
 *   Url: location of the db
 *   username
 *   password
 * 
 * Step 2: execute the queries
 *  Statement
 *  PreparedStatement
 * ===============================================================================
 * 
 * Step 3: retrieve the content
 *   ResultSet
 * 
 * JDBI -> Java DB Interface
 *  -> open source
 *  -> Apache
 * 
 * Fluent API
 * Declarative API
 *  1. Connection Class
 *  2. Queries -> DAO (Data Access Object)
 *  3. Mapper
 *  4. Factory classes to implement the queries
 * 
 */

package com.hexaware.carsdemo.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.Statement;

public class DBConnection {
  public void getConnect() {
    String url = "jdbc:mysql://localhost:3306/carsdemo?useSSL=false";
    String user = "root";
    String pass = "root";
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, user, pass);
      
      if (con != null) {
        // Statement stmt = con.createStatement();
        // ResultSet rs = stmt.executeQuery("SELECT * FROM CARS");

        // while (rs.next()) {
        //   System.out.println(rs.getInt("ID") + " " + rs.getString("NAME") +" " + rs.getDouble("PRICE"));
        // }

        PreparedStatement ps = con.prepareStatement("INSERT INTO CARS (NAME, ID, PRICE) VALUES (?, ?, ?)");

        ps.setInt(2, 16);
        ps.setString(1, "Lexus");
        ps.setDouble(3, 15000000.00);

        int i = ps.executeUpdate();

        if (i > 0){
          System.out.println("Successful");
        } else {
          System.out.println("Unsuccessful");
        }
      }
    } catch (Exception e) {

    }
  }
}

// import org.skife.jdbi.v2.DBI;

// public class DBConnection {
  
//   public final DBI getConnect() {
//     try {
//       Class.forName("com.mysql.jdbc.Driver");

//       //dbi object has 3 parts
//       //URL -> Universal Resource Locator
//       //username
//       //password
//       DBI dbi = new DBI("jdbc:mysql://localhost:3306/carsdemo?useSSL=false", "root", "root");
//       return dbi;
//     } catch (ClassNotFoundException e) {
//       throw new RuntimeException(e);
//     }
//   }
// }
