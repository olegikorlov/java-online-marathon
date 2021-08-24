package com.olegorlov.softserve.jom.sprint01;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {
    Student student = new Student();
    Student student1 = new Student();
    Student student2 = new Student();

    System.out.println(Student.count);

    Student student3 = new Student();
    Student student4 = new Student();
    Student student5 = new Student();

    System.out.println(Student.count);

    Employee emp1 = new Employee();
    emp1.setFullName("Oleg");
    emp1.setSalary(1300.00f);

    Employee emp2 = new Employee();
    emp2.setFullName("Andrey");
    emp2.setSalary(1200.00f);

    Employee[] employees = {emp1, emp2};

    StringBuilder employeesInfoBuilder = new StringBuilder("[");
    for (int i = 0; i < employees.length; i++) {

      employeesInfoBuilder
          .append(String.format("{fullName: \"%s\", salary: %.2f}",
              employees[i].getFullName(), employees[i].getSalary()));
/*
          .append("{fullName: \"")
          .append(employees[i].getFullName())
          .append("\", salary: ")
          .append(employees[i].getSalary())
          .append("}");
*/

      if (i < employees.length - 1) {
        employeesInfoBuilder.append(", ");
      }

    }

    employeesInfoBuilder.append("]");

    String employeesInfo = employeesInfoBuilder.toString();

    System.out.println(employeesInfo);

    Point point = new Point(4, 7);
    System.out.println(String.format("%.2f", point.distance(3, 8)));

    Point point1 = new Point(4, 7);
    System.out.println(String.format("%.2f", point1.distance(new Point(3, 8))));

    Point point2 = new Point(7, 5);
    System.out.println(String.format("%.2f", point2.distance()));

  }

}
