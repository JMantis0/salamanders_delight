package com.controllers;

import com.pojos.Manager;
import com.pojos.ReimbursementRequest;
import javafx.util.Pair;
import com.pojos.Employee;

public interface Controller {
    Pair<String, Integer> loginAttemptAndGetNextURL(String empID, String password, String loginType);
    void createRequest(ReimbursementRequest request);
    void updateOneEmployeeField(String empID, String field, String value);
    Manager getCurrentManagerProfile(String manID);
    Employee getCurrentEmployeeProfile(String empID);
}
