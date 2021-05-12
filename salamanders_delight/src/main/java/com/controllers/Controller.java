package com.controllers;

import com.pojos.ReimbursementRequest;
import javafx.util.Pair;

public interface Controller {
    Pair<String, Integer> loginAttemptAndGetNextURL(String empID, String password);
    void createRequest(ReimbursementRequest request);
}
