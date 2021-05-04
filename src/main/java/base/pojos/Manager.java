package base.pojos;

import org.bson.types.ObjectId;

public class Manager extends Employee {
    public Manager() {
    }

    public Manager(String firstName, String lastName, int empID, String password, ObjectId _id) {
        super(firstName, lastName, empID, password, _id);
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    @Override
    public int getEmpID() {
        return super.getEmpID();
    }

    @Override
    public void setEmpID(int empID) {
        super.setEmpID(empID);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public ObjectId get_id() {
        return super.get_id();
    }

    @Override
    public void set_id(ObjectId _id) {
        super.set_id(_id);
    }
}
