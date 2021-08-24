package com.olegorlov.softserve.jom.sprint01;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class Employee {
  private String fullName;
  private float salary;

  public Employee() {
  }

  public Employee(String fullName, float salary) {
    this.fullName = fullName;
    this.salary = salary;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public float getSalary() {
    return salary;
  }

  public void setSalary(float salary) {
    this.salary = salary;
  }
}
