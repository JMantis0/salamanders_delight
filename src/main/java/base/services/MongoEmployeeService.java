package base.services;

import base.daos.Dao;
import base.pojos.Employee;

public class MongoEmployeeService implements MongoService{
    private Dao dao;

    public MongoEmployeeService(Dao dao) {this.dao = dao;}

    @Override
    public Object findOne(String id) {
        return null;
    }

    public boolean doesUserExist(String empID) {
        System.out.println("Inside MongoEmployeeService : doesUserExists(" + empID + ")");
        boolean userExists = false;
        Employee emp = dao.getEmployee(empID);
        System.out.println("Value of emp: " + emp);
        if(emp != null) {
            userExists = true;
        }
        return userExists;
    }

    @Override
    public boolean isPasswordValid(String empID, String passwordAttempt) {
        System.out.println("Inside MongoEmployeeService: isPasswordValid(" + empID + ", " + passwordAttempt + ")");
        boolean passwordIsValid = false;
        System.out.println("Calling dao.getEmployeePassword(" + empID + ")");
        String correctPassword = dao.getEmployeePassword(empID);
        System.out.println("result is: " + correctPassword);
        System.out.println("Does the login password from client, " + passwordAttempt + "match the actual password, " + correctPassword + "?");
        if(passwordAttempt.equals(correctPassword)) {
            System.out.println("Yes, it matches");
            passwordIsValid = true;
        } else {
            System.out.println("It does not match");
        }
        return passwordIsValid;
    }
}
