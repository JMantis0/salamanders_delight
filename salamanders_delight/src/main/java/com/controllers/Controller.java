package com.controllers;

import com.pojos.ReimbursementRequest;
import javafx.util.Pair;
import com.pojos.Employee;

public interface Controller {
    Pair<String, Integer> loginAttemptAndGetNextURL(String empID, String password, String loginType);
    void createRequest(ReimbursementRequest request);
    Employee getCurrentUserProfile(String empID);
    void updateOneEmployeeField(String empID, String field, String value);
}
