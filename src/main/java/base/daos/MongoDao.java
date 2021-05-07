package base.daos;

import base.MongoConnector;
import base.pojos.Employee;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import java.util.ArrayList;
import java.util.Iterator;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;

public class MongoDao implements Dao {
    MongoConnector connector;
    MongoCollection<Employee> employees;

    public MongoDao(MongoConnector connector) {
        this.connector = connector;
        this.employees = this.connector
                .getClient()
                .getDatabase("salamander")
                .getCollection("employees", Employee.class);
    }

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
        System.out.println("did it return anything?");
        System.out.println("Inside MongoDao. correctPassword is: " + correctPassword);
        return correctPassword;
    }

    @Override
    public Employee getEmployee(String empID) {
        System.out.println("Inside MongoDao getEmployee(" + empID + ").");
        Employee emp = employees.find(eq("empID", empID)).first();
        System.out.println("emp is: " + emp);
        return employees.find(eq("empID", empID)).first();
    }
}
