package com.services;

import com.daos.Dao;
import com.mongodb.client.FindIterable;
import com.pojos.ReimbursementRequest;
import org.bson.types.ObjectId;
import java.util.List;


public class MongoReimbursementService implements MongoService {
    private Dao dao;

    public MongoReimbursementService() {
    }

    public MongoReimbursementService(Dao dao) {
        this.dao = dao;
    }

    /**
     * Simply calls the dao to query all reimbursement requests in the DB with requestorID field matching
     * the empID String.
     *
     * @param empID used to query the MongoDB employee collection.
     * @return
     */
    public FindIterable<ReimbursementRequest> getAllRequestsByEmpID(String empID) {
        System.out.println("Inside MongoReimbursementService getAllRequestsByEmpID");
        FindIterable<ReimbursementRequest> allRequests = dao.getAllRequestsByUserID(empID);
        return allRequests;
    }

    public void createRequest(ReimbursementRequest request) {
        System.out.println("Inside MongoReimbursement service createRequest");
        dao.createRequest(request);
    }

    public List<ReimbursementRequest> getAllRequests() {
        return dao.getAllRequests();
    }

    public void resolveRequest(ObjectId objectId, String resolver, String resolution) {
        dao.resolveRequest(objectId, resolver, resolution);
    }
}
