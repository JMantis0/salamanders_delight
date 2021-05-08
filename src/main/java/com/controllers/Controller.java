package com.controllers;

import javafx.util.Pair;

public interface Controller {
    Pair<String, Integer> loginAttemptAndGetNextURL(String empID, String password);
}
