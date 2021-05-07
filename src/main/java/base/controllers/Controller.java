package base.controllers;

import base.services.MongoService;

public class Controller {
    protected MongoService service;

    public Controller() {}
    public Controller(MongoService service) {
        this.service = service;
    }

    /**
     *
     * @param empID provided by the client.  Used as parameter in service method calls.
     * @param password provided by the client.  Used as parameter in service method calls.
     * @return nextURL - instructs the client which page to render next.
     */
    public String loginAttemptAndGetNextURL(String empID, String password) {
        String nextURL;
        System.out.println("Inside Controller \n Method loginAttempt(" + empID + ", " + password + ")");
        //First see if there exists a user with empID.
        boolean doesUserExist = service.doesUserExist(empID);
        if(doesUserExist) {
            //  The user exists.  Now check if client provided the correct user password.
            boolean isPasswordValid = service.isPasswordValid(empID, password);
            if (isPasswordValid) {
                // The Password is valid.  Return the EmployeeHome URL
                nextURL = "/employeehome";
            } else {
                //  The Password is invalid.  Return the InvalidPassword URL
                nextURL = "/invalidpassword";
            }
        } else {
            //  No such user exists.  Return the NoSuchUser URL
            nextURL = "/nosuchuser";
        }
        return nextURL;
    }

    public MongoService getService() {
        return service;
    }

    public void setService(MongoService service) {
        this.service = service;
    }

}
