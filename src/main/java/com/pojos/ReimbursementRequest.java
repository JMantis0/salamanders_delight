package com.pojos;

import org.bson.types.ObjectId;

public class ReimbursementRequest {
    private int amount;
    private boolean resolved;
    private String requesterID;
    private String justification;
    private ObjectId id;

    public ReimbursementRequest() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    public String getRequesterID() {
        return requesterID;
    }

    public void setRequesterID(String requesterID) {
        this.requesterID = requesterID;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ReimbursementRequest{" +
                "amount=" + amount +
                ", resolved=" + resolved +
                ", requesterID='" + requesterID + '\'' +
                ", justification='" + justification + '\'' +
                ", id=" + id +
                '}';
    }
}
