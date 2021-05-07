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
        if(emp != null) {
            userExists = true;
        }
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
    @Override
    public boolean isPasswordValid(String empID, String passwordAttempt) {
        System.out.println("Inside MongoEmployeeService: isPasswordValid(" + empID + ", " + passwordAttempt + ")");
        boolean passwordIsValid = false;
        String correctPassword = dao.getEmployeePassword(empID);
        if(passwordAttempt.equals(correctPassword)) {
            passwordIsValid = true;
        }
        return passwordIsValid;
    }
}
