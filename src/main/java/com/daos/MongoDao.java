package com.daos;

import com.utils.MongoConnector;
import com.pojos.Employee;
import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;

/**
 * <h1>MongoDao</h1>
 * <h2>Data Access Object</h2>
 * <h3>implements Dao</h3>
 */

public class MongoDao implements Dao {
    MongoConnector connector;
    MongoCollection<Employee> employees;

    public MongoDao(){}
    public MongoDao(MongoConnector connector) {
        this.connector = connector;
        this.employees = this.connector
                .getClient()
                .getDatabase("salamander")
                .getCollection("employees", Employee.class);
    }

    /**
     * Queries the MongoDB for an employee with empID field matching the empID String parameter, and gets its password.
     * If no such employee exists, null is returned.
     * @param empID used to query the MongoDB employee collection.
     * @return correctPassword - A string that contains the password value stored in the employee record, or null
     * if there is no such employee.
     */
    @Override
    public String getEmployeePassword(String empID) {
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

    /**
     * Queries the DB for an employee with empID field matching the empID String parameter and
     * returns the employee, if it exists.  Otherwise, null is returned.
     * @param empID used to query the MongoDB employee collection.
     * @return an Employee object, or null.
     */
    @Override
    public Employee getEmployee(String empID) {
        System.out.println("Inside MongoDao getEmployee(" + empID + ").");
        Employee emp = employees.find(eq("empID", empID)).first();
        return emp;
    }
}
