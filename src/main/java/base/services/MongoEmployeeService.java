package base.services;

import base.daos.Dao;

public class MongoEmployeeService implements MongoService{
    private Dao dao;

    public MongoEmployeeService(Dao dao) {this.dao = dao;}

    @Override
    public Object findOne(String id) {
        return null;
    }

    public boolean checkIfPasswordMatches(String clientPasswordAttempt, int empID) {
        //First get the password stored in db.
        String correctPassword = dao.getEmployeePassword(empID);
        if (clientPasswordAttempt == correctPassword) {
            return true;
        } else {
            return false;
        }
    }
}
