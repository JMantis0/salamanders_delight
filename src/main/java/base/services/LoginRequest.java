package base.services;

public class LoginRequest {
    String empID;
    String password;

    public LoginRequest() {
    }

    public LoginRequest(String empID, String password) {
        this.empID = empID;
        this.password = password;
    }

}
