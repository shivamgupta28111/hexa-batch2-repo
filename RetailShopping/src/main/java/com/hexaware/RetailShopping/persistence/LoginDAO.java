package com.hexaware.RetailShopping.persistence;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;

/**
 * LoginDAO class used to fetch data from database.
 */
public interface LoginDAO {
  /**
   * return all the user records.
   * @return a list of logins
   */
  @SqlQuery("SELECT * FROM LOGIN")
  @Mapper(LoginMapper.class)
  List<Login> showAll();

  /**
   * to get the userId for a particular username.
   * @return the login id
   */
  @SqlQuery("SELECT LOGINID FROM LOGIN WHERE USERNAME = :userName")
  int getLoginId(@Bind("userName") String userName);

  /**
   * to insert a row into Login table.
   */
  @SqlUpdate("INSERT INTO LOGIN VALUES (:loginId, :username, :password, :usertype)")
  void addUser(@Bind("loginId") int loginId, @Bind("username") String userName,
      @Bind("password") String password, @Bind("usertype") String userType);

  /**
   * to update the loginId with the userId - either supplierId or buyerId
   */
  @SqlUpdate("UPDATE LOGIN SET LOGINID = :userId WHERE USERNAME = :username")
  void updateUserId(@Bind("userId") int userId, @Bind("username") String userName);
}