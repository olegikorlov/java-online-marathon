package com.olegorlov.softserve.jom.sprint06.question3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {

  static BinaryOperator<String> greetingOperator =
      (parameter1, parameter2) -> String.format("Hello %s %s!!!",parameter1, parameter2);

  public static List<String> createGreetings(List<Person> people, BinaryOperator<String> greetingOperator) {
    List<String> result = new ArrayList<>();

    for (Person person : people) {
      result.add(greetingOperator.apply(person.name, person.surname));
    }
    return result;
  }

}

class Person {

  String name;
  String surname;

  public Person(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }

}
