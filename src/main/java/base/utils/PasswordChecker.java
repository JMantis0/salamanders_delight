package base.utils;

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
}
