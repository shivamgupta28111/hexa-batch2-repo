package com.hexaware.RetailShopping.factory;

import java.util.List;

import com.hexaware.RetailShopping.model.Login;
import com.hexaware.RetailShopping.persistence.DbConnection;
import com.hexaware.RetailShopping.persistence.LoginDAO;

/**
 * Login factory for working with login table.
 */
public class LoginFactory {
  /**
   * protected constructor.
   */
  protected LoginFactory() {

  }

   /**
   * dao method for working with LoginDAO.
   * @return LoginDAO object
   */
  private static LoginDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LoginDAO.class);
  }

  /**
   * list all users.
   * @return login array
   */
  public static Login[] listAllUsers() {
    List<Login> users = dao().showAll();
    return users.toArray(new Login[users.size()]);
  }

  /**
   * retrieve login details for particular username.
   * @param argUser for username
   * @return login object
   */
  public static Login getLoginDetails(final String argUser) {
    Login login = dao().findbyUserName(argUser);
    return login;
  }

  /**
   * for new user.
   * @param argLogin for user id
   * @param user for username
   * @param pass for password
   * @param ut for usertype
   * @return int
   */
  public static int registerLogin(final int argLogin, final String user, final String pass, final String ut) {
    int res = dao().registerLogin(argLogin, user, pass, ut);
    return res;
  }

  /**
   * for updating password.
   * @param argUserId for user id
   * @param pass for new password
   * @return string
   */
  public static String updatePassword(final int argUserId, final String pass) {
    String msg = "Password Update Unsuccessful";

    int res = dao().updatePassword(pass, argUserId);
    if (res > 0) {
      msg = "Password Updated Successfully";
    }
    return msg;
  }
}
