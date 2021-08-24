package com.olegorlov.softserve.jom.sprint01;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class Student {
  private String name;
  private int age;
  public static int count = 0;

  public Student() {
    count++;
  }

  public Student(String name) {
    this.name = name;
    count++;
  }

  public Student(String name, int age) {
    this.name = name;
    this.age = age;
    count++;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
