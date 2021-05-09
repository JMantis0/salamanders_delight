package com.repositories;

import com.mongodb.client.MongoCollection;
import com.pojos.ReimbursementRequest;
import com.utils.MongoConnector;

import java.util.Collection;

public class ReimbursementRequestRepository implements Repository {
    private MongoConnector connector;
    private MongoCollection<ReimbursementRequest> reimbursementRequests;

    public ReimbursementRequestRepository(MongoConnector connector) {
        this.connector = connector;
        this.reimbursementRequests = this.connector
                .getClient()
                .getDatabase("salamander")
                .getCollection("reimbursementRequests", ReimbursementRequest.class);
    }

    @Override
    public ReimbursementRequest findById(Object o) {
        return null;
    }

    @Override
    public Collection<ReimbursementRequest> findAll() {
        return null;
    }
}
