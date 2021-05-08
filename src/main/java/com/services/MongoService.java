package com.services;

/**
 *<h1>Interface MongoService</h1>
 * <h2>implemented by Service(s) that intermediate bewteen Dao and Controller</h2>
 * @param <E> can be <ul><li>Employee</li><li>ReimbursementRequest</li><li>Manager</li></ul>
 */
public interface MongoService<E> {
    E findOne(String id);
    boolean isPasswordValid(String empID, String password);
    boolean doesUserExist(String empID);
}
