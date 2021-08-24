package com.olegorlov.softserve.jom.sprint02.question01;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {

  }
}

class Person {

  int age;
  String name;
  String healthInfo;

  public Person(int age, String name, String healthInfo) {
    this.age = age;
    this.name = name;
    this.healthInfo = healthInfo;
  }

  String getHealthStatus() {
    return name + " " + healthInfo;
  }

}

class Child extends Person {

  String childIDNumber;

  public Child(int age, String name, String healthInfo, String childIDNumber) {
    super(age, name, healthInfo);
    this.childIDNumber = childIDNumber;
  }

}

class Adult extends Person {

  String passportNumber;

  public Adult(int age, String name, String healthInfo, String passportNumber) {
    super(age, name, healthInfo);
    this.passportNumber = passportNumber;
  }

}
