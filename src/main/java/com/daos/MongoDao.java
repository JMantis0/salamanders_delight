package com.daos;

import com.mongodb.MongoClientSettings;
import com.utils.MongoConnector;
import com.pojos.Employee;
import com.mongodb.client.MongoCollection;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

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
        //This configuration can be removed from the constructor and instead be a executed by a method.
        this.employees = this.connector
                .getClient()
                .getDatabase("salamander")
                .getCollection("employees", Employee.class);
    }

    public MongoConnector getConnector() {
        return connector;
    }

    public MongoCollection<Employee> getEmployees() {
        return employees;
    }

    public void setConnector(MongoConnector connector) {
        this.connector = connector;
    }

    public void setEmployees(MongoCollection<Employee> employees) {
        this.employees = employees;
    }

    //Make a new method that configures the employees collection settings.
    public void configureEmployeesCollection() {
        this.employees= this.connector
                .getClient()
                .getDatabase("salamander")
                .getCollection("employees", Employee.class);
    }

    /**
     * Configures the connector.  The string in .register() should path to pojos package.
     * the String in newConnectionString() is the mongoDB url that points to your db.
     */
    public void configureConnectorCodecAndRegistryAndCreateClient() {
        connector.configure( () -> {
            CodecProvider codecProvider = PojoCodecProvider.builder().register("com.pojos").build();
            CodecRegistry registry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), CodecRegistries.fromProviders(codecProvider));
            return MongoClientSettings.builder()
                    .applyConnectionString(connector.newConnectionString("mongodb://localhost:27017/salamander"))
                    .retryWrites(true)
                    .codecRegistry(registry)
                    .build();
        }).createClient();
    }

    //Make new Constructor that accepts a MongoCollection Object as a parameter.  This will make the code more testable.
    public MongoDao(MongoConnector connector, MongoCollection<Employee> employees) {
        this.connector = connector;
        this.employees = employees;
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
