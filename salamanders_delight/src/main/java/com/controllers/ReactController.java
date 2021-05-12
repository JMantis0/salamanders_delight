package com.controllers;
;
import com.mongodb.client.FindIterable;
import com.pojos.ReimbursementRequest;
import com.services.MongoEmployeeService;
import com.services.MongoReimbursementService;
import com.services.MongoService;
import javafx.util.Pair;

import java.util.ArrayList;

/**
 * <h1>ReactController</h1>
 * <h2>implements Controller</h2>
 *
 * <p>Communicates between Service object and Servlet Object.</p>
 * <p>Responsible for instructing the client which view to display based on responses from Service object.</p>
 */


public class ReactController implements Controller {
    protected MongoService service;
    public ReactController() {}
    public ReactController(MongoService service) {
        this.service = service;
    }

    /**
     *
     * @param empID provided by the client.  Used as parameter in service method calls.
     * @param password provided by the client.  Used as parameter in service method calls.
     * @return nextURL - instructs the client which page to render next.
     */
    public Pair<String, Integer> loginAttemptAndGetNextURL(String empID, String password) {
        Pair<String, Integer> nextURLandStatus;
        System.out.println("Inside Controller \n Method loginAttempt(" + empID + ", " + password + ")");
        //First see if there exists a user with empID.
        boolean doesUserExist = ((MongoEmployeeService)service).doesUserExist(empID);

        if(doesUserExist) {
            //  The user exists.  Now check if client provided the correct user password.
            boolean isPasswordValid = ((MongoEmployeeService)service).isPasswordValid(empID, password);
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
        return nextURLandStatus;
    }

    public FindIterable<ReimbursementRequest> getAllRequestsByEmpID(String empID) {
        System.out.println("Inside Controller getAllREquestsByEmpID" + empID);
        FindIterable<ReimbursementRequest> allRequests = ((MongoReimbursementService)service).getAllRequestsByEmpID(empID);
        return allRequests;
    };

    @Override
    public void createRequest(ReimbursementRequest request) {
        System.out.println("Inside Controller createRequest");
        ((MongoReimbursementService)service).createRequest(request);
    }
}
