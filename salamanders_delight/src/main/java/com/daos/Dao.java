package com.daos;


import com.mongodb.client.FindIterable;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import com.pojos.Employee;
import com.pojos.Manager;
import com.pojos.ReimbursementRequest;
import com.utils.MongoConnector;
import org.bson.types.ObjectId;

import java.util.List;


public interface Dao {
    String getEmployeePasswordByUserID(String empID);
    Employee getEmployeeByUserID(String empID);
    FindIterable<ReimbursementRequest> getAllRequestsByUserID(String empID);
    InsertOneResult createRequest(ReimbursementRequest request);
    UpdateResult updateOneEmployeeField(String empID, String field, String value);
    Manager getManagerByUserID(String managerID);
    String getManagerPasswordByUserID(String managerID);
    List<ReimbursementRequest> getAllRequests();
    UpdateResult resolveRequest(ObjectId objectId, String resolver, String resolution);
    List<Employee> getAllEmployees();

}
