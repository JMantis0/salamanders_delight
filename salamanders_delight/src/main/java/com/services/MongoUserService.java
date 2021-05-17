package com.services;

import com.daos.Dao;
import com.mongodb.client.result.UpdateResult;
import com.pojos.Employee;
import com.pojos.Manager;

import java.util.List;

public class MongoUserService implements MongoService{
    private Dao dao;

    public MongoUserService(){}

    public MongoUserService(Dao dao) {
        this.dao = dao;
    }



    /**
     * <p>
     * Returns a boolean value representing whether there exists an employee document in the MongoDB for the given
     * String parameter.
     * </p>
     * @param empID a String containing and employee ID.
     * @return userExists - a boolean whose value indicates whether or not such an employee exists.
     */
    public boolean doesEmployeeExist(String empID) {
        System.out.println("doesEmployeeExist(" + empID + ")");
        boolean userExists = false;
        Employee emp = dao.getEmployeeByUserID(empID);
        if(emp != null) {
            userExists = true;
        }
        System.out.println("userExists: " + userExists);
        return userExists;
    }


    /**
     * This method checks to see if the password stored in the database for the empID provided by the
     * client matches with the password provided by the client.
     * This method should only be called when an employ with the empID is known to exist in the database.
     * @param empID provided by client, used to call the dao.
     * @param passwordAttempt  provided by client, used to compare with password in DB.
     * @return boolean passwordIsValid - Represents whether the password provided by the client is correct or incorrect.
     */
    public boolean isEmployeePasswordValid(String empID, String passwordAttempt) {
        System.out.println(" isEmployeePasswordValid(" + empID + ", " + passwordAttempt + ")");
        boolean passwordIsValid = false;
        String correctPassword = dao.getEmployeePasswordByUserID(empID);
        if(passwordAttempt.equals(correctPassword)) {
            passwordIsValid = true;
        }
        return passwordIsValid;
    }
    public boolean doesManagerExist(String managerID) {
        System.out.println("Inside Service : doesUserExists(" + managerID + ")");
        boolean userExists = false;
        Manager mgr = dao.getManagerByUserID(managerID);
        if(mgr != null) {
            userExists = true;
        }
        System.out.println("userExists: " + userExists);
        return userExists;
    }

    public boolean isManagerPasswordValid(String managerID, String passwordAttempt) {
        System.out.println("Inside Service: isManagerPasswordValid(" + managerID + ", " + passwordAttempt + ")");
        boolean passwordIsValid = false;
        String correctPassword = dao.getManagerPasswordByUserID(managerID);
        System.out.println("Inside userService again, correctPassword = " + correctPassword);
        if(passwordAttempt.equals(correctPassword)) {
            passwordIsValid = true;
            System.out.println(passwordAttempt + correctPassword);
        }
        return passwordIsValid;
    }

    public Employee getEmployeeByEmpID(String empID) {
        System.out.println("Inside service getEmployeeByEmpID("+empID+")");
        return dao.getEmployeeByUserID(empID);
    }

    public Manager getManagerByUserID(String manID) {
        System.out.println("Inside service getManagerByManagerID("+manID+")");
        return dao.getManagerByUserID(manID);
    }

    public UpdateResult updateOneEmployeeField(String empID, String field, String value) {
        System.out.println(2);
        return dao.updateOneEmployeeField(empID, field, value);
    }

    public List<Employee> getAllEmployees() {
        System.out.println("UserService getAllEMployees");
      return dao.getAllEmployees();
  }

}
