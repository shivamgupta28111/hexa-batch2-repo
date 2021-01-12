package com.hexaware.RetailShopping.model;

import java.util.Objects;
/**
 * class for login credentials.
 */
public class Login {

  /**
   * userId for userId.
   */
  private int userId;
  /**
   * userName for username.
   */
  private String userName;
  /**
   * password for password.
   */
  private String password;
  /**
   * userType for user type.
   */
  private UserType userType;

  /**
   *
   * @return userId.
   */
  public final int getUserId() {
    return this.userId;
  }

  /**
   *
   * @param argUserId for loginId.
   */
  public final void setUserId(final int argUserId) {
    this.userId = argUserId;
  }

  /**
   *
   * @return userName.
   */
  public final String getUserName() {
    return this.userName;
  }

  /**
   *
   * @param argUserName for username.
   */
  public final void setUserName(final String argUserName) {
    this.userName = argUserName;
  }

  /**
   *
   * @return password.
   */
  public final String getPassword() {
    return this.password;
  }

  /**
   *
   * @param argPassword for password.
   */
  public final void setPassword(final String argPassword) {
    this.password = argPassword;
  }

  /**
   *
   * @return userType.
   */
  public final UserType getUserType() {
    return this.userType;
  }

  /**
   *
   * @param argUserType for userType.
   */
  public final void setUserType(final UserType argUserType) {
    this.userType = argUserType;
  }

  /**
   * default constructor.
   */
  public Login() {

  }

  /**
   * parameterized constructor.
   * @param argUserId for login id
   * @param argUserName for user name
   * @param argPassword for password
   * @param argUserType for user type
   */
  public Login(final int argUserId, final String argUserName, final String argPassword,
      final UserType argUserType) {
    this.userId = argUserId;
    this.userName = argUserName;
    this.password = argPassword;
    this.userType = argUserType;
  }

  /**
   * equals method.
   * @param obj Object
   * @return true or false
   */
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Login login = (Login) obj;
    if (Objects.equals(userId, login.userId)
        && Objects.equals(userName, login.userName)
        && Objects.equals(password, login.password)
        && Objects.equals(userType, login.userType)) {
      return true;
    }
    return false;
  }

  /**
   * hashcode method.
   * @return hash code
   */
  @Override
  public final int hashCode() {
    return Objects.hash(userId, userName, password, userType);
  }

  /**
   * toString method.
   * @return string
   */
  @Override
  public final String toString() {
    return "Login: [User Id: " + this.userId
        + " Username: " + this.userName
        + " Password: " + this.password
        + " User Type: " + this.userType
        + " ]";
  }
}
