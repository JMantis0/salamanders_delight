package com.daos;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.pojos.Manager;
import com.pojos.ReimbursementRequest;
import com.utils.MongoConnector;
import com.pojos.Employee;
import com.mongodb.client.MongoCollection;

import java.util.Iterator;

import static com.mongodb.client.model.Filters.eq;

/**
 * <h1>MongoDao</h1>
 * <h2>Data Access Object</h2>
 * <h3>implements Dao</h3>
 */

public class MongoDao implements Dao {
    MongoConnector connector;
    MongoCollection<Employee> employees;
    MongoCollection<Manager> managers;
    MongoCollection<ReimbursementRequest> requests;

    public MongoDao(){}
    public MongoDao(MongoConnector connector) {
        this.connector = connector;
        //This configuration can be removed from the constructor and instead be a executed by a method.
        this.employees = this.connector
                .getClient()
                .getDatabase("salamander")
                .getCollection("employees", Employee.class);
        this.managers = this.connector
                .getClient()
                .getDatabase("salamander")
                .getCollection("managers", Manager.class);
        this.requests = this.connector
                .getClient()
                .getDatabase("salamander")
                .getCollection("requests", ReimbursementRequest.class);
    }

    /**
     * Queries the MongoDB for an employee with empID field matching the empID String parameter, and gets its password.
     * If no such employee exists, null is returned.
     * @param empID used to query the MongoDB employee collection.
     * @return correctPassword - A string that contains the password value stored in the employee record, or null
     * if there is no such employee.
     */
    @Override
    public String getEmployeePasswordByEmpID(String empID) {
        System.out.println("Inside MongoDao getEmployeePassword(" + empID + ").");
        String correctPassword;
        try {
            correctPassword = employees.find(eq("empID", empID)).first().getPassword();
        } catch(NullPointerException e) {
            e.printStackTrace();
            System.out.println("No such user exists");
            correctPassword = null;
        }
        return correctPassword;
    }

    @Override
    public String getManagerPasswordByManagerID(String managerID) {
        System.out.println("Inside MongoDao getManagerPasswordByManagerID(" + managerID + ").");
        String correctPassword;
        try {
            correctPassword = managers.find(eq("managerID", managerID)).first().getPassword();
            System.out.println(correctPassword);
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("No such user exists");
            correctPassword = null;
        }
        System.out.println("returning password");
        return correctPassword;
    }

    /**
     * Queries the DB for an employee with empID field matching the empID String parameter and
     * returns the employee, if it exists.  Otherwise, null is returned.
     * @param empID used to query the MongoDB employee collection.
     * @return an Employee object, or null.
     */
    @Override
    public Employee getEmployeeByEmpID(String empID) {
        System.out.println("Inside MongoDao getEmployee(" + empID + ").");
        Employee emp = employees.find(eq("empID", empID)).first();
        return emp;
    }

    @Override
    public Manager getManagerByManagerID(String managerID) {
        System.out.println("Inside MongoDao getEmployee(" + managerID + ").");
        Manager mgr= managers.find(eq("managerID", managerID)).first();
        return mgr;
    }


    /**
     * Queries the DB for all reimbursement requests with requesterID field matching the empID String parameter
     * and returns the collection.
     * @param empID used to query the MongoDB employee collection.
     * @return a FindIterable{@code <ReimbursementRequest>}
     */
    @Override
    public FindIterable<ReimbursementRequest> getAllRequestsByEmpID(String empID) {
        System.out.println("Inside MongoDao getAllRequestsByEmpID");
        try{
            FindIterable<ReimbursementRequest> allRequests = requests.find(eq("requesterID", empID));
            return allRequests;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void createRequest(ReimbursementRequest request) {
        System.out.println("Inside MongoDao createRequest");
        requests.insertOne(request);
    }

    public void setEmployees(MongoCollection<Employee> employees) {
        this.employees = employees;
    }

    public void setManagers(MongoCollection<Manager> managers) {
        this.managers = managers;
    }

    public void setReimbursementRequests(MongoCollection<ReimbursementRequest> reimbursementRequests) {
        this.requests = reimbursementRequests;
    }

    @Override
    public void updateOneEmployeeField(String empID, String field, String value) {
        BasicDBObject query = new BasicDBObject();
        query.put("empID", empID); // (1)

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put(field, value); // (2)

        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument); // (3)

        employees.updateOne(query, updateObject); // (4)
        System.out.println(3);
    }
}
