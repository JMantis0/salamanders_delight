package com.daos;


import com.mongodb.client.FindIterable;
import com.pojos.Employee;
import com.pojos.Manager;
import com.pojos.ReimbursementRequest;
import com.utils.MongoConnector;


public interface Dao {
    //Model the db
    String getEmployeePasswordByUserID(String empID);
    Employee getEmployeeByUserID(String empID);
    FindIterable<ReimbursementRequest> getAllRequestsByUserID(String empID);
    void createRequest(ReimbursementRequest request);
    void updateOneEmployeeField(String empID, String field, String value);
    Manager getManagerByManagerID(String managerID);
    String getManagerPasswordByManagerID(String managerID);
}
