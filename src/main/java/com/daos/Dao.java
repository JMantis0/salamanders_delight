package com.daos;

import com.pojos.Employee;

public interface Dao {
    //Model the db
    String getEmployeePassword(String empID);
    Employee getEmployee(String empID);
}
