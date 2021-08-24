package com.olegorlov.softserve.jom.sprint04.question2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {

  public static void main(String[] args) {

/*
list1 [Students [id=1, name=Ivan], Students [id=2, name=Petro], Students [id=3, name=Stepan]]

and

list2 [Students [id=1, name=Ivan], Students [id=3, name=Stepan], Students [id=4, name=Andriy]]

you should get

[Students [id=3, name=Stepan], Students [id=1, name=Ivan]]


*/
    List<Student> list1 = new ArrayList<>();
    list1.add(new Student(1, "Ivan"));
    list1.add(new Student(2, "Petro"));
    list1.add(new Student(3, "Stepan"));

    List<Student> list2 = new ArrayList<>();
    list2.add(new Student(1, "Ivan"));
    list2.add(new Student(3, "Stepan"));
    list2.add(new Student(4, "Andriy"));

    Set<Student> result = commonStudents(list1, list2);
    System.out.println(result);
  }

  public static class Student {

    private int id;
    private String name;

    public Student(int id, String name) {
      this.id = id;
      this.name = name;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Student)) return false;

      Student student = (Student) o;

      if (id != student.id) return false;
      return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
      int result = id;
      result = 31 * result + (name != null ? name.hashCode() : 0);
      return result;
    }

    @Override
    public String toString() {
      return String.format("%s [id=%d, name=%s]",
          getClass().getSimpleName(), id, name);
    }

  }

  public static Set<Student> commonStudents(List<Student> list1, List<Student> list2) {
    Set<Student> result = new HashSet<>();

    for (Student student : list1) {
      if (list2.contains(student)) {
        result.add(student);
      }
    }
    return result;
  }

}



