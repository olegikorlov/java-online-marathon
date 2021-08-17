package com.olegorlov.softservejom.sprint03.question04;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {
    // [Employee [name=Ivan, experience=10, basePayment=3000.00],
    // Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5],
    // Employee [name=Stepan, experience=8, basePayment=4000.00],
    // Employee [name=Andriy, experience=7, basePayment=3500.00],
    // Employee [name=Ihor, experience=5, basePayment=4500.00],
    // Manager [name=Vasyl, experience=8, basePayment=2000.00, coefficient=2.0]]

    List<Employee> workers = new ArrayList<>();
    workers.add(new Employee("Ivan", 10, new BigDecimal(3000)));
    workers.add(new Employee("Ivan", 10, new BigDecimal(3000)));
    workers.add(new Employee("Ivan", 10, new BigDecimal(3000)));
    workers.add(new Manager("Petro", 9, new BigDecimal(3000), 1.5));
    workers.add(new Manager("Karl", 9, new BigDecimal(3000), 1.5));
    workers.add(new Manager("Jonh", 5, new BigDecimal(7000), 1.5));
    workers.add(new Employee("Stepan", 8, new BigDecimal(4000)));
    workers.add(new Employee("Stepan", 8, new BigDecimal(4000)));
    workers.add(new Employee("Stepan", 8, new BigDecimal(4000)));
    workers.add(new Employee("Stepan", 8, new BigDecimal(4000)));
    workers.add(new Employee("Andriy", 7, new BigDecimal(3500)));
    workers.add(new Employee("Ihor", 5, new BigDecimal(4500)));
    workers.add(new Employee("Ihor", 5, new BigDecimal(4500)));
    workers.add(new Employee("Ihor", 5, new BigDecimal(4500)));
    workers.add(new Manager("Vasyl", 8, new BigDecimal(2000), 2.0));

/*
    workers.add(new Employee("Ivan", 10, new BigDecimal(3000.00)));
    workers.add(new Manager("Petro", 9, new BigDecimal(2000.00), 1.5));
    workers.add(new Employee("Stepan", 8, new BigDecimal(4000.00)));
    workers.add(new Employee("Andriy", 7, new BigDecimal(3500.00)));
    workers.add(new Employee("Ihor", 5, new BigDecimal(4500.00)));
    workers.add(new Manager("Vasyl", 8, new BigDecimal(1000.00), 2.0));
    workers.add(new Employee("Yuriy", 7, new BigDecimal(3500.00)));
    workers.add(new Employee("Tofik", 10, new BigDecimal(2000.00)));
    workers.add(new Employee("Margo", 4, new BigDecimal(4500.00)));
*/
//    workers.add(null);

    System.out.println(workers + "\n\n");

    System.out.println(new MyUtils().largestEmployees(workers));
  }

}

class Employee {

  private String name;
  private int experience;
  private BigDecimal basePayment;

  public Employee(String name, int experience, BigDecimal basePayment) {
    this.name = name;
    this.experience = experience;
    this.basePayment = basePayment;
  }

  public String getName() {
    return name;
  }

  public int getExperience() {
    return experience;
  }

  public BigDecimal getPayment() {
    return basePayment;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Employee)) return false;

    Employee employee = (Employee) o;

    if (experience != employee.experience) return false;
    if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
    return basePayment != null ? basePayment.equals(employee.basePayment) : employee.basePayment == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + experience;
    result = 31 * result + (basePayment != null ? basePayment.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return String.format("%s [name=%s, experience=%d, basePayment=%.2f]",
        getClass().getSimpleName(), name, experience, basePayment);
  }
}

class Manager extends Employee {

  private double coefficient;

  public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
    super(name, experience, basePayment);
    this.coefficient = coefficient;
  }

  public double getCoefficient() {
    return coefficient;
  }

  @Override
  public BigDecimal getPayment() {
    return super.getPayment().multiply(new BigDecimal(coefficient));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Manager)) return false;
    if (!super.equals(o)) return false;

    Manager manager = (Manager) o;

    return Double.compare(manager.coefficient, coefficient) == 0;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    long temp;
    temp = Double.doubleToLongBits(coefficient);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return String.format("%s [name=%s, experience=%d, basePayment=%.2f, coefficient=%.2f]",
        getClass().getSimpleName(), getName(), getExperience(), getPayment(), getCoefficient());
  }
}

class MyUtils {

  public List<Employee> largestEmployees(List<Employee> workers) {
    if (workers.isEmpty()) {
      return new ArrayList<>();
    }
    if (workers.size() == 1) {
      return new ArrayList<>(workers);
    }
    List<Employee> result = new ArrayList<>();
    List<Employee> employees = new ArrayList<>();
    List<Employee> managers = new ArrayList<>();
    for (Employee employee : workers) {
      if (employee instanceof Manager) {
        managers.add(employee);
      } else {
        employees.add(employee);
      }
    }

    if (managers.size() > 0) {
      addToResultListMostExperienceEmployee(result, managers);
      addToResultListMostPaymentEmployee(result, managers);
    }

    if (employees.size() > 0) {
      addToResultListMostExperienceEmployee(result, employees);
      addToResultListMostPaymentEmployee(result, employees);
    }

    result.sort(new EmployeeMostExperienceComparator());
    return result;
  }

  private void addToResultListMostPaymentEmployee(List<Employee> result, List<Employee> employees) {
    employees.sort(new EmployeeMostPaymentComparator());
    for (Employee employee : employees) {
      if (employees.get(0).getPayment().equals(employee.getPayment()) && !result.contains(employee)) {
        result.add(employee);
      } else {
        break;
      }
    }
  }

  private void addToResultListMostExperienceEmployee(List<Employee> result, List<Employee> employees) {
    employees.sort(new EmployeeMostExperienceComparator());
    for (Employee employee : employees) {
      if (employees.get(0).getExperience() == employee.getExperience() && !result.contains(employee)) {
        result.add(employee);
      } else {
        break;
      }
    }
  }

  private class EmployeeMostExperienceComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
      if (Integer.compare(o2.getExperience(), o1.getExperience()) == 0) {
        return Double.compare(o2.getPayment().doubleValue(), o1.getPayment().doubleValue());
      }
      if (Integer.compare(o2.getExperience(), o1.getExperience()) == 0) {
        return o2.getName().compareTo(o1.getName());
      }
      return Integer.compare(o2.getExperience(), o1.getExperience());
    }
  }

  private class EmployeeMostPaymentComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
      if (o2.getPayment().compareTo(o1.getPayment()) == 0) {
        return Integer.compare(o2.getExperience(), o1.getExperience());
      }
      if (o2.getPayment().compareTo(o1.getPayment()) == 0) {
        return o2.getName().compareTo(o1.getName());
      }
      return o2.getPayment().compareTo(o1.getPayment());
    }
  }

}

