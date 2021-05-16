package com.daos;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.pojos.Manager;
import com.pojos.ReimbursementRequest;
import com.utils.MongoConnector;
import com.pojos.Employee;
import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public MongoDao() {
    }

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
     * Queries the MongoDB for an employee with userID field matching the userID String parameter, and gets its password.
     * If no such employee exists, null is returned.
     *
     * @param userID used to query the MongoDB employee collection.
     * @return correctPassword - A string that contains the password value stored in the employee record, or null
     * if there is no such employee.
     */
    @Override
    public String getEmployeePasswordByUserID(String userID) {
        System.out.println("Inside MongoDao getEmployeePassword(" + userID + ").");
        String correctPassword;
        try {
            correctPassword = employees.find(eq("userID", userID)).first().getPassword();
        } catch (NullPointerException e) {
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
            correctPassword = managers.find(eq("userID", managerID)).first().getPassword();
            System.out.println(correctPassword);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such user exists");
            correctPassword = null;
        }
        System.out.println("returning password");
        return correctPassword;
    }

    /**
     * Queries the DB for an employee with userID field matching the userID String parameter and
     * returns the employee, if it exists.  Otherwise, null is returned.
     *
     * @param userID used to query the MongoDB employee collection.
     * @return an Employee object, or null.
     */
    @Override
    public Employee getEmployeeByUserID(String userID) {
        System.out.println("Inside MongoDao getEmployee(" + userID + ").");
        Employee emp = employees.find(eq("userID", userID)).first();
        return emp;
    }

    @Override
    public Manager getManagerByManagerID(String managerID) {
        System.out.println("Inside MongoDao getManager(" + managerID + ").");
        Manager mgr = managers.find(eq("userID", managerID)).first();
        return mgr;
    }


    /**
     * Queries the DB for all reimbursement requests with requesterID field matching the userID String parameter
     * and returns the collection.
     *
     * @param userID used to query the MongoDB employee collection.
     * @return a FindIterable{@code <ReimbursementRequest>}
     */
    @Override
    public FindIterable<ReimbursementRequest> getAllRequestsByUserID(String userID) {
        System.out.println("Inside MongoDao getAllRequestsByuserID");
        try {
            FindIterable<ReimbursementRequest> allRequests = requests.find(eq("requesterID", userID));
            return allRequests;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ReimbursementRequest> getAllRequests() {
        try {

        System.out.println("Inside dao getAllRequests()");
        FindIterable<ReimbursementRequest> allRequests = requests.find();
        List<ReimbursementRequest> list = new ArrayList<>();
        for (ReimbursementRequest request : allRequests) {
            list.add(request);
        }
        return list;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
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
    public void updateOneEmployeeField(String userID, String field, String value) {
        System.out.println("dao updateOneEmployeeField(" + userID + ", " + field + ", " + value + ")");
        BasicDBObject query = new BasicDBObject();
        query.put("userID", userID);

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put(field, value);

        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument);

        employees.updateOne(query, updateObject);

    }

    @Override
    public void resolveRequest(ObjectId objectId, String resolver, String resolution) {
        System.out.println("dao resolveRequest(" + objectId + ". " + resolver + ", " + resolution + ")");
        BasicDBObject query = new BasicDBObject();
        query.put("_id", objectId);

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("status", resolution);
        newDocument.put("resolvedBy", resolver);

        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument);

        requests.updateOne(query, updateObject);

    }
}
