package com.repositories;

import com.mongodb.client.MongoCollection;
import com.pojos.Employee;
import com.utils.MongoConnector;
import org.bson.types.ObjectId;

import java.util.Collection;

public class EmployeeRepository implements Repository<Employee, ObjectId> {
    private MongoConnector connector;
    private MongoCollection<Employee> employees;

    public EmployeeRepository(MongoConnector connector) {
        this.connector = connector;
        this.employees = this.connector.getClient()
                .getDatabase("salamander")
                .getCollection("employees", Employee.class);
    }

    @Override
    public Employee findById(ObjectId objectId) {
        return null;
    }

    @Override
    public Collection findAll() {
        return null;
    }
}
