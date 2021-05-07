package base.services;

public interface MongoService<E> {
    E findOne(String id);
    boolean isPasswordValid(String empID, String password);
    boolean doesUserExist(String empID);
}
