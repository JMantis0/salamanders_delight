package com.controllers;

;
import com.mongodb.client.FindIterable;
import com.mongodb.client.result.UpdateResult;
import com.pojos.Manager;
import com.pojos.ReimbursementRequest;
import com.services.*;
import javafx.util.Pair;
import com.pojos.Employee;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * <h1>ReactController</h1>
 * <h2>implements Controller</h2>
 *
 * <p>Communicates between Service object and Servlet Object.</p>
 * <p>Responsible for instructing the client which view to display based on responses from Service object.</p>
 */


public class ReactController implements Controller {
    protected MongoService service;

    public ReactController() {
    }

    public ReactController(MongoService service) {
        this.service = service;
    }

    /**
     * @param empID    provided by the client.  Used as parameter in service method calls.
     * @param password provided by the client.  Used as parameter in service method calls.
     * @return nextURL - instructs the client which page to render next.
     */
    @Override
    public Pair<String, Integer> loginAttemptAndGetNextURL(String id, String password, String loginType) {
        Pair<String, Integer> nextURLandStatus;
        if ("employee".equals(loginType)) {
            String empID = id;
            System.out.println("Inside Controller \n Method employee loginAttempt(" + empID + ", " + password + ", " + loginType + ")");

            //First see if there exists a user with empID.
            boolean doesUserExist;
            try {
                doesUserExist = ((MongoUserService) service).doesEmployeeExist(empID);
            } catch (Exception e) {
                e.printStackTrace();
                doesUserExist = false;
            }

            if (doesUserExist) {
                //  The user exists.  Now check if client provided the correct user password.
                boolean isPasswordValid = ((MongoUserService) service).isEmployeePasswordValid(empID, password);
                if (isPasswordValid) {
                    // The Password is valid.  Return the EmployeeHome URL
                    nextURLandStatus = new Pair<>("/employee_home", 200);
                } else {
                    //  The Password is invalid.  Return the InvalidPassword URL
                    nextURLandStatus = new Pair<>("/invalid_password", 401);
                }
            } else {
                //  No such user exists.  Return the NoSuchUser URL
                nextURLandStatus = new Pair<>("/no_such_user", 401);
            }
        } else if ("manager".equals(loginType)) {
            //manager code here.
            String managerID = id;
            System.out.println("Inside Controller \n Method manager loginAttempt(" + managerID + ", " + password + ", " + loginType + ")");
            //First see if there exists a user with empID.
            boolean doesUserExist;
            try {
                doesUserExist = ((MongoUserService) service).doesManagerExist(managerID);
            } catch (Exception e) {
                e.printStackTrace();
                doesUserExist = false;
            }

            if (doesUserExist) {
                //  The user exists.  Now check if client provided the correct user password.
                boolean isPasswordValid = ((MongoUserService) service).isManagerPasswordValid(managerID, password);
                System.out.println("Is Password Valid? " + isPasswordValid);
                if (isPasswordValid) {
                    // The Password is valid.  Return the EmployeeHome URL
                    nextURLandStatus = new Pair<>("/manager_home", 200);
                } else {
                    //  The Password is invalid.  Return the InvalidPassword URL
                    nextURLandStatus = new Pair<>("/invalid_password", 401);
                }
            } else {
                //  No such user exists.  Return the NoSuchUser URL
                nextURLandStatus = new Pair<>("/no_such_user", 401);
            }
        } else {
            System.out.println("Something went wrong.");
            nextURLandStatus = null;
        }
        return nextURLandStatus;
    }

    @Override
    public FindIterable<ReimbursementRequest> getAllRequestsByEmpID(String empID) {
        System.out.println("Inside Controller getAllREquestsByEmpID" + empID);
        FindIterable<ReimbursementRequest> allRequests = ((MongoReimbursementService) service).getAllRequestsByEmpID(empID);
        return allRequests;
    }
    @Override
    public void createRequest(ReimbursementRequest request) {
        System.out.println("Inside Controller createRequest");
        ((MongoReimbursementService) service).createRequest(request);
    }

    @Override
    public Employee getCurrentEmployeeProfile(String empID) {
        System.out.println("Inside controller getCurrentUserProfile" + empID + ")");
        Employee emp = ((MongoUserService) service).getEmployeeByEmpID(empID);
        return emp;
    }

    @Override
    public Manager getCurrentManagerProfile(String manID) {
        System.out.println("Inside controller getCurrentUserProfile" + manID + ")");
        Manager manager = ((MongoUserService) service).getManagerByUserID(manID);
        return manager;
    }

    @Override
    public UpdateResult updateOneEmployeeField(String empID, String field, String value) {
        System.out.println(1);
        return ((MongoUserService) service).updateOneEmployeeField(empID, field, value);
    }

    @Override
    public List<ReimbursementRequest> getAllRequests() {
        return ((MongoReimbursementService) service).getAllRequests();
    }

    @Override
    public void resolveRequest(ObjectId objectId, String resolver, String resolution) {
        ((MongoReimbursementService) service).resolveRequest(objectId, resolver, resolution);
    }

    @Override
    public List<Employee> getAllEmployees() {
        System.out.println("controller getALlEmployees");
        return ((MongoUserService) service).getAllEmployees();
    }
}
