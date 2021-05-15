package com.utils;

/**
 * <h1>PasswordChecker</h1>
 * <h2>A pojo-style util used by LoginServlet to store <code>empID</code> and <code>password</code> Strings</h2>
 */

public class PasswordChecker {
    private String userID;
    private String password;
    private String loginType;

    public PasswordChecker(){}
    public PasswordChecker(String userID, String password, String loginType) {
        this.userID = userID;
        this.password = password;
        this.loginType = loginType;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    @Override
    public String toString() {
        return "PasswordChecker{" +
                "userID='" + userID + '\'' +
                ", password='" + password + '\'' +
                ", loginType='" + loginType + '\'' +
                '}';
    }
}