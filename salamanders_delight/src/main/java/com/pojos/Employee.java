package com.pojos;

import org.bson.types.ObjectId;

/**
 * <h1>Employee Pojo</h1>
 * <h2>Class for Object representation of Employee MongoDB Document</h2>
 */
public class Employee {
  private String firstName;
  private String lastName;
  private String empID;
  private String password;
  private ObjectId id; // For Mongo

  //Constructors
  public Employee() {
  }

  public Employee(String firstName, String lastName, String empID, String password, ObjectId id) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.empID = empID;
    this.password = password;
    this.id = id;
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

  public ObjectId getId() {
    return id;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", empID='" + empID + '\'' +
            ", password='" + password + '\'' +
            ", id=" + id +
            '}';
  }
}
