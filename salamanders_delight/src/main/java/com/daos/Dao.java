package com.daos;


import com.mongodb.client.FindIterable;
import com.pojos.Employee;
import com.pojos.ReimbursementRequest;
import com.utils.MongoConnector;


public interface Dao {
    //Model the db
    String getEmployeePasswordByEmpID(String empID);
    Employee getEmployeeByEmpID(String empID);
    FindIterable<ReimbursementRequest> getAllRequestsByEmpID(String empID);
    void createRequest(ReimbursementRequest request);
}
