package com.hexaware.RetailShopping.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.RetailShopping.model.Login;
import com.hexaware.RetailShopping.model.UserType;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

/**
 * LoginMapper class.
 */
public class LoginMapper implements ResultSetMapper<Login> {

  /**
   * map method.
   * @param idx for index
   * @param rs for resultset
   * @param ctx for context
   * @return login object
   * @throws SQLException for SQL exception
   */
  public final Login map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    UserType ut = UserType.valueOf(rs.getString("USERTYPE"));
    return new Login(rs.getInt("LOGINID"), rs.getString("USERNAME"),
        rs.getString("PASSCODE"), ut);
  }
}
