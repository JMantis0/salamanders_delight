package base.pojos;

import org.bson.types.ObjectId;

public class Employee {
  private String firstName;
  private String lastName;
  private String empID;
  private String password;
  private boolean isManager;
  private ObjectId _id; // For Mongo

  //Constructors
  public Employee() {
  }

  public Employee(String firstName, String lastName, String empID, String password, ObjectId _id) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.empID = empID;
    this.password = password;
    this._id = _id;
  }

  //  S/G etters
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmpID() {
    return empID;
  }

  public void setEmpID(String empID) {
    this.empID = empID;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isManager() {
    return isManager;
  }

  public void setManager(boolean manager) {
    isManager = manager;
  }

  public ObjectId get_id() {
    return _id;
  }

  public void set_id(ObjectId _id) {
    this._id = _id;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", empID='" + empID + '\'' +
            ", password='" + password + '\'' +
            ", isManager=" + isManager +
            ", _id=" + _id +
            '}';
  }
}
