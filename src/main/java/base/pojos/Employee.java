package base.pojos;

import org.bson.types.ObjectId;



public class Employee {
  String firstName;
  String lastName;
  int empID;
  String password;
  ObjectId _id;

  //Constructors
  public Employee() {
  }

  public Employee(String firstName, String lastName, int empID, String password, ObjectId _id) {
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

  public int getEmpID() {
    return empID;
  }

  public void setEmpID(int empID) {
    this.empID = empID;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public ObjectId get_id() {
    return _id;
  }

  public void set_id(ObjectId _id) {
    this._id = _id;
  }
}
