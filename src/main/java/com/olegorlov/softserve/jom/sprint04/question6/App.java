package com.olegorlov.softserve.jom.sprint04.question6;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {

  public static <T extends Person> void print(T t) {
    System.out.println(t.toString());
  }

  public static void main(String[] args) {

    Person[] people = {
        new Person("Nick", 27),
        new Person("Sara", 24),
        new Person("Bart", 38),
        new Person("Nick", 21),
        new Person("Sara", 24),
        new Person("Bart", 38)
    };

    System.out.println("\nBefore==============");
    for (Person person : people) {
      print(person);
    }

    System.out.println("After===============");
    Utility.sortPeople(people, new PersonComparator());
    for (Person person : people) {
      print(person);
    }

    Employee[] employees = {
        new Employee("Nick", 27, 2850.55),
        new Employee("Sara", 24, 2950.35),
        new Employee("Bart", 38, 3165.75),
        new Employee("Nick", 21, 1940.25),
        new Employee("Sara", 24, 2260.65),
        new Employee("Bart", 38, 3165.75)
    };

    System.out.println("\nBefore==============");
    for (Employee employee : employees) {
      print(employee);
    }

    System.out.println("After===============");
    Utility.sortPeople(employees, new EmployeeComparator());
    for (Employee employee : employees) {
      print(employee);
    }

    Developer[] developers = {
        new Developer("Nick", 27, 2850.55, Level.MIDDLE),
        new Developer("Sara", 24, 2950.35, Level.SENIOR),
        new Developer("Bart", 38, 3165.75, Level.MIDDLE),
        new Developer("Nick", 21, 1940.25, Level.JUNIOR),
        new Developer("Sara", 24, 2260.65, Level.MIDDLE),
        new Developer("Bart", 38, 3165.75, Level.JUNIOR)
    };

    System.out.println("\nBefore==============");
    for (Developer developer : developers) {
      print(developer);
    }

    System.out.println("After===============");
    Utility.sortPeople(developers, new DeveloperComparator());
    for (Developer developer : developers) {
      print(developer);
    }

  }

}

/*
class PersonComparator implements Comparator<Person> {

  @Override
  public int compare(Person o1, Person o2) {
    final int nameCompareResult = o1.getName().compareTo(o2.getName());
    if (nameCompareResult != 0) {
      return nameCompareResult;
    }
    return Integer.compare(o1.getAge(), o2.getAge());
  }

}

class EmployeeComparator implements Comparator<Employee> {

  @Override
  public int compare(Employee o1, Employee o2) {
    final int personCompareResult = new PersonComparator().compare(o1, o2);
    if (personCompareResult != 0) {
      return personCompareResult;
    }
    return Double.compare(o1.getSalary(), o2.getSalary());
  }

}

class DeveloperComparator implements Comparator<Developer> {

  @Override
  public int compare(Developer o1, Developer o2) {
    final int employeeCompareResult = new EmployeeComparator().compare(o1, o2);
    if (employeeCompareResult != 0) {
      return employeeCompareResult;
    }
    return o1.getLevel().compareTo(o2.getLevel());
  }
}
*/

class PersonComparator implements Comparator<Object> {

  @Override
  public int compare(Object o1, Object o2) {
    Person person1 = (Person) o1;
    Person person2 = (Person) o2;
    final int nameCompareResult = person1.getName().compareTo(person2.getName());
    if (nameCompareResult != 0) {
      return nameCompareResult;
    }
    return Integer.compare(person1.getAge(), person2.getAge());
  }

}

class EmployeeComparator extends PersonComparator {

  @Override
  public int compare(Object o1, Object o2) {
    final int personCompareResult = super.compare(o1, o2);
    if (personCompareResult != 0) {
      return personCompareResult;
    }
    Employee employee1 = (Employee) o1;
    Employee employee2 = (Employee) o2;
    return Double.compare(employee1.getSalary(), employee2.getSalary());
  }

}

class DeveloperComparator extends EmployeeComparator {

  @Override
  public int compare(Object o1, Object o2) {
    final int developerCompareResult = super.compare(o1, o2);
    if (developerCompareResult != 0) {
      return developerCompareResult;
    }
    Developer developer1 = (Developer) o1;
    Developer developer2 = (Developer) o2;
    return developer1.getLevel().compareTo(developer2.getLevel());
  }
}

class Utility {

  public static <T extends Person> void sortPeople(T[] array, Comparator<? super T> comparator) {
    Arrays.sort(array, comparator);
  }

}

class Person {

  protected String name;
  protected int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return String.format("Name: %s, Age: %d",
        name, age);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Person)) return false;

    Person person = (Person) o;

    if (age != person.age) return false;
    return name != null ? name.equals(person.name) : person.name == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + age;
    return result;
  }

}

class Employee extends Person {

  private double salary;

  public Employee(String name, int age, double salary) {
    super(name, age);
    this.salary = salary;
  }

  public double getSalary() {
    return salary;
  }

  @Override
  public String toString() {
    return String.format("%s, Salary: %.2f", super.toString(), salary);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Employee)) return false;
    if (!super.equals(o)) return false;

    Employee employee = (Employee) o;

    return Double.compare(employee.salary, salary) == 0;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    long temp;
    temp = Double.doubleToLongBits(salary);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

}

class Developer extends Employee {

  private Level level;

  public Developer(String name, int age, double salary, Level level) {
    super(name, age, salary);
    this.level = level;
  }

  public Level getLevel() {
    return level;
  }

  @Override
  public String toString() {
    return String.format("%s, Level: %s", super.toString(), level.name());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Developer)) return false;
    if (!super.equals(o)) return false;

    Developer developer = (Developer) o;

    return level == developer.level;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (level != null ? level.hashCode() : 0);
    return result;
  }

}

enum Level {
  JUNIOR,
  MIDDLE,
  SENIOR;
}