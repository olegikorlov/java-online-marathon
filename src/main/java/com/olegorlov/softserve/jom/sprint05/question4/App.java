package com.olegorlov.softserve.jom.sprint05.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {
//    System.out.println("1323567890".matches("\\d{10}"));
//    System.out.println(Person.buildPerson("Kelly", "Oros", "2345765678").toString());
//    System.out.println(Person.buildPerson("io", "Oros", "23").toString());
    System.out.println(Person.buildPerson("joe", "KlarK2", "AS-2").toString());
//    System.out.println(Person.buildPerson("", "", "").toString());
    Person person = null;
    System.out.println(person);
  }
}

class Person {

  private static final String COMMON_MESSAGE_IN_NAME_EXCEPTION = "" +
      "Incorrect value %s for %s " +
      "(should start from upper case and contains " +
      "only alphabetic characters and symbols -, _)";

  private String firstName;
  private String lastName;
  private String idCode;

  public void setFirstName(String firstName) {
    if (!firstName.matches("[A-Z][a-z]*")) {
      throw new NameException(String.format(
          COMMON_MESSAGE_IN_NAME_EXCEPTION,
          firstName, "firstName"));
    } else {
      this.firstName = firstName;
    }
  }

  public String getFirstName() {
    return firstName;
  }

  public void setLastName(String lastName) {
    if (!lastName.matches("[A-Z][a-z]*")) {
      throw new NameException(String.format("" +
              COMMON_MESSAGE_IN_NAME_EXCEPTION,
          lastName, "lastName"));
    } else {
      this.lastName = lastName;
    }
  }

  public String getLastName() {
    return lastName;
  }

  public void setIdCode(String idCode) {
    if (!idCode.matches("\\d{10}")) {
      throw new CodeException(
          String.format("Incorrect value %s for code (should contains exactly 10 digits)",
              idCode));
    } else {
      this.idCode = idCode;
    }
  }

  public String getIdCode() {
    return idCode;
  }

  public static Person buildPerson(String firstName, String lastName, String idCode) {
    Person person = new Person();
    List<Exception> exceptions = new ArrayList<>();

    try {
      person.setFirstName(firstName);
    } catch (NameException e) {
      exceptions.add(e);
    }

    try {
      person.setLastName(lastName);
    } catch (NameException e) {
      exceptions.add(e);
    }

    try {
      person.setIdCode(idCode);
    } catch (CodeException e) {
      exceptions.add(e);
    }

    if (exceptions.isEmpty()) {
      return person;
    }

    StringBuilder stringBuilder = new StringBuilder();
    for (Exception exception : exceptions) {
      stringBuilder
          .append(exception.getMessage())
          .append("; ");
    }
/*
    for (Iterator<Exception> iterator = exceptions.iterator(); iterator.hasNext(); ) {
      stringBuilder
          .append(iterator.next().getMessage())
          .append("; ");
    }
*/
    throw new IllegalArgumentException(stringBuilder.substring(0, stringBuilder.length() - 2));

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Person)) return false;

    Person person = (Person) o;

    if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
    if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
    return idCode != null ? idCode.equals(person.idCode) : person.idCode == null;
  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (idCode != null ? idCode.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return String.format("%s %s: %s",
        firstName, lastName, idCode);
  }
}

class NameException extends RuntimeException {
  public NameException(String message) {
    super(message);
  }
}

class CodeException extends RuntimeException {
  public CodeException(String message) {
    super(message);
  }
}
