package base.daos;

import base.MongoConnector;
import base.pojos.Employee;
import com.mongodb.client.MongoCollection;

public class MongoDao implements Dao {
    MongoConnector connector;
    MongoCollection<Employee> employees;

    public MongoDao(MongoConnector connector) {
        this.connector = connector;
        this.employees = this.connector
                .getClient()
                .getDatabase("pzbank")
                .getCollection("employees", Employee.class);
    }

    @Override
    public String getEmployeePassword(int empID) {
        return null;
    }
}
