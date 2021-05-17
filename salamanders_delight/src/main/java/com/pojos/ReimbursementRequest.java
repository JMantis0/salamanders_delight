package com.pojos;

import org.bson.types.ObjectId;

public class ReimbursementRequest {
    private double amount;
    private String status;
    private String resolvedBy;
    private String requesterID;
    private String justification;
    private ObjectId id;
    private String customId;

    public ReimbursementRequest() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResolvedBy() {
        return resolvedBy;
    }

    public void setResolvedBy(String resolvedBy) {
        this.resolvedBy = resolvedBy;
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

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    @Override
    public String toString() {
        return "ReimbursementRequest{" +
                "amount=" + amount +
                ", status='" + status + '\'' +
                ", resolvedBy='" + resolvedBy + '\'' +
                ", requesterID='" + requesterID + '\'' +
                ", justification='" + justification + '\'' +
                ", id=" + id +
                ", customId='" + customId + '\'' +
                '}';
    }
}
