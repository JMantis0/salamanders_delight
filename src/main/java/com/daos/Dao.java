package com.daos;


import com.pojos.Employee;
import com.utils.MongoConnector;


public interface Dao {
    //Model the db
    String getEmployeePasswordByEmpID(String empID);
    Employee getEmployeeByEmpID(String empID);
}
