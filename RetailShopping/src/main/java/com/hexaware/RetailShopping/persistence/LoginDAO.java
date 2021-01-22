package com.hexaware.RetailShopping.persistence;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

import com.hexaware.RetailShopping.model.Login;
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
   * to update password.
   * @param pass for password
   * @param userId for user id
   * @return int
   */
  @SqlUpdate("UPDATE LOGIN SET PASSCODE = :pass WHERE LOGINID = :userId")
  int updatePassword(@Bind("pass") final String pass, @Bind("userId") final int userId);

  /**
   * to update the loginId.
   * @param userId for loginId
   * @param userName for username
   */
  @SqlUpdate("UPDATE LOGIN SET LOGINID = :userId WHERE USERNAME = :username")
  void updateUserId(@Bind("userId") int userId, @Bind("username") String userName);

  /**
   * to get the login details.
   * @param userName for username
   * @return login object
   */
  @SqlQuery("SELECT * FROM LOGIN WHERE USERNAME = :userName")
  @Mapper(LoginMapper.class)
  Login findbyUserName(@Bind("userName") final String userName);

  /**
   * for inserting new user.
   * @param loginId for user id
   * @param username for user name
   * @param passcode for password
   * @param usertype for usertype
   * @return int
   */
  @SqlUpdate("INSERT INTO LOGIN VALUES (:loginId, :username, :passcode, :usertype)")
  int registerLogin(@Bind("loginId") final int loginId, @Bind("username") final String username,
      @Bind("passcode") final String passcode, @Bind("usertype") final String usertype);
}
