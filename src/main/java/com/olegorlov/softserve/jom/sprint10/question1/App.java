package com.olegorlov.softserve.jom.sprint10.question1;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) throws SQLException {
    MyUtils myUtils = new MyUtils();
    myUtils.createConnection();
    myUtils.createStatement();
    myUtils.createSchema("TestSchema");
    myUtils.useSchema();
    myUtils.createTableRoles();
    myUtils.insertTableRoles("Developer");
    myUtils.insertTableRoles("DevOps");
    myUtils.insertTableRoles("QC");
    List<String> roles = myUtils.getAllRoles();
    System.out.println(roles.stream()
        .collect(Collectors.joining(", ")));

    myUtils.createTableDirections();
    myUtils.insertTableDirections("Java");
    myUtils.insertTableDirections("Python");
    myUtils.insertTableDirections(".Net");
    List<String> directions = myUtils.getAllDirestion();
    System.out.println(directions.stream()
        .collect(Collectors.joining(", ")));

    myUtils.createTableProjects();
    myUtils.insertTableProjects("MoonLight", "Java");
    myUtils.insertTableProjects("Sun", "Java");
    myUtils.insertTableProjects("Mars", "Python");
    List<String> projects = myUtils.getAllProjects();
    System.out.println(projects.stream()
        .collect(Collectors.joining(", ")));

    myUtils.createTableEmployee();
    myUtils.insertTableEmployee("Ivan", "Developer", "MoonLight");
    myUtils.insertTableEmployee("Petro", "Developer", "Sun");
    myUtils.insertTableEmployee("Stepan", "Developer", "Mars");
    myUtils.insertTableEmployee("Andriy", "DevOps", "Mars");
    myUtils.insertTableEmployee("Vasyl", "DevOps", "Mars");
    myUtils.insertTableEmployee("Ira", "Developer", "MoonLight");
    myUtils.insertTableEmployee("Anna", "QC", "MoonLight");
    myUtils.insertTableEmployee("Olya", "QC", "Sun");
    myUtils.insertTableEmployee("Maria", "QC", "Mars");
    List<String> employees = myUtils.getAllEmployee();
    System.out.println(employees.stream()
        .collect(Collectors.joining(", ")));

    List<String> developers = myUtils.getAllDevelopers();
    System.out.println(developers.stream()
        .collect(Collectors.joining(", ")));

    List<String> javaProjects = myUtils.getAllJavaProjects();
    System.out.println(javaProjects.stream()
        .collect(Collectors.joining(", ")));

    List<String> javaDevelopers = myUtils.getAllJavaDevelopers();
    System.out.println(javaDevelopers.stream()
        .collect(Collectors.joining(", ")));

    myUtils.dropSchema();
    myUtils.closeConnection();

  }

}
