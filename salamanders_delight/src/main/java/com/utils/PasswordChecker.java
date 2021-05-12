package com.utils;

/**
 * <h1>PasswordChecker</h1>
 * <h2>A pojo-style util used by LoginServlet to store <code>empID</code> and <code>password</code> Strings</h2>
 */

public class PasswordChecker {
    private String empID;
    private String password;

    public PasswordChecker(String empID, String password) {
        this.empID = empID;
        this.password = password;
    }

    public PasswordChecker() {
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PasswordChecker{" +
                "empID='" + empID + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}