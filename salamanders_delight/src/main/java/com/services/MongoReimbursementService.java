package com.services;

import com.daos.Dao;
import com.mongodb.client.FindIterable;
import com.pojos.ReimbursementRequest;

public class MongoReimbursementService implements MongoService {
    private Dao dao;

    public MongoReimbursementService(){}

    public MongoReimbursementService(Dao dao) {
        this.dao = dao;
    }

    @Override
    public Object findOne(String id) {
        return null;
    }

    /**
     * Simply calls the dao to query all reimbursement requests in the DB with requestorID field matching
     * the empID String.
     * @param empID used to query the MongoDB employee collection.
     * @return
     */
    public FindIterable<ReimbursementRequest> getAllRequestsByEmpID(String empID) {
        System.out.println("Inside MongoReimbursementService getAllRequestsByEmpID ONE");
        FindIterable<ReimbursementRequest> allRequests = dao.getAllRequestsByEmpID(empID);
        //  Maybe here I would like to manipulate the data structure before giving it to the controller.

        return allRequests;
    }

    public void createRequest(ReimbursementRequest request) {
        System.out.println("Inside MongoReimbursement service createRequest");
        dao.createRequest(request);
    }

}
