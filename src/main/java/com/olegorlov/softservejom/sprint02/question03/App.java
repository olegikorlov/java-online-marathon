package com.olegorlov.softservejom.sprint02.question03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {

    // [Person [name=Ivan],
    // Student [name=Petro, studyPlace=University, studyYears=3],
    // Worker [name=Andriy, workPosition=Developer, experienceYears=12],
    // Student [name=Stepan, studyPlace=College, studyYears=4],
    // Worker [name=Ira, workPosition=Manager, experienceYears=8],
    // Student [name=Ihor, studyPlace=University, studyYears=4]]

    Person person = new Person("Ivan");
    Student student = new Student("Petro", "University" , 3);
    Worker worker = new Worker("Andriy", "Developer", 12);
    Student student1 = new Student("Stepan", "College" , 4);
    Worker worker1 = new Worker("Ira", "Manager", 8);
    Student student2 = new Student("Ihor", "University" , 4);

    List<Person> people = new ArrayList<>();
    people.add(person);
    people.add(student);
    people.add(worker);
    people.add(student1);
    people.add(worker1);
    people.add(student2);

    System.out.println(people);

    System.out.println(new MyUtils().maxDuration(people));
  }

}

class Person {

  private String name;

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Person)) return false;

    Person person = (Person) o;

    return name != null ? name.equals(person.name) : person.name == null;
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }

  @Override
  public String toString() {
    return String.format("%s [name=%s]", getClass().getSimpleName(), getName());
  }

}

class Student extends Person {

  private String studyPlace;
  private int studyYears;

  public Student(String name, String studyPlace, int studyYears) {
    super(name);
    this.studyPlace = studyPlace;
    this.studyYears = studyYears;
  }

  public String getStudyPlace() {
    return studyPlace;
  }

  public int getStudyYears() {
    return studyYears;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Student)) return false;
    if (!super.equals(o)) return false;

    Student student = (Student) o;

    if (studyYears != student.studyYears) return false;
    return studyPlace != null ? studyPlace.equals(student.studyPlace) : student.studyPlace == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (studyPlace != null ? studyPlace.hashCode() : 0);
    result = 31 * result + studyYears;
    return result;
  }

  @Override
  public String toString() {
    return String.format("%s [name=%s, studyPlace=%s, studyYears=%s]",
        getClass().getSimpleName(), getName(), getStudyPlace(), getStudyYears());
  }
}

class Worker extends Person {

  private String workPosition;
  private int experienceYears;

  public Worker(String name, String workPosition, int experienceYears) {
    super(name);
    this.workPosition = workPosition;
    this.experienceYears = experienceYears;
  }

  public String getWorkPosition() {
    return workPosition;
  }

  public int getExperienceYears() {
    return experienceYears;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Worker)) return false;
    if (!super.equals(o)) return false;

    Worker worker = (Worker) o;

    if (experienceYears != worker.experienceYears) return false;
    return workPosition != null ? workPosition.equals(worker.workPosition) : worker.workPosition == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (workPosition != null ? workPosition.hashCode() : 0);
    result = 31 * result + experienceYears;
    return result;
  }

  @Override
  public String toString() {
    return String.format("%s [name=%s, workPosition=%s, experienceYears=%s]",
        getClass().getSimpleName(), getName(), getWorkPosition(), getExperienceYears());
  }

}

class MyUtils {

  private class WorkerComparator implements Comparator<Worker> {
    @Override
    public int compare(Worker o1, Worker o2) {
      return Integer.compare(o2.getExperienceYears(), o1.getExperienceYears());
    }
  }

  private class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
      return Integer.compare(o2.getStudyYears(), o1.getStudyYears());
    }
  }


  public List<Person> maxDuration(List<Person> persons) {

    List<Student> students = new ArrayList<>();
    List<Worker> workers = new ArrayList<>();
    List<Person> result = new ArrayList<>();

    for (Person person : persons) {
      if (person instanceof Worker) {
        workers.add((Worker) person);
      } else if (person instanceof Student) {
        students.add((Student) person);
      }
    }

    if (workers.size() > 1) {
      workers.sort(new WorkerComparator());
      Worker worker0 = workers.get(0);
      Worker worker1 = workers.get(1);

      if (worker0.getExperienceYears() > worker1.getExperienceYears()) {
        result.add(worker0);
      } else if (!worker0.equals(worker1)) {
        result.add(worker0);
        result.add(worker1);
      }
    } else if (workers.size() == 1) {
      result.add(workers.get(0));
    }

    if (students.size() > 1) {
      students.sort(new StudentComparator());
      Student student0 = students.get(0);
      Student student1 = students.get(1);

      if (student0.getStudyYears() > student1.getStudyYears()) {
        result.add(student0);
      } else if (!student0.equals(student1)) {
        result.add(student0);
        result.add(student1);
      }
    } else if (students.size() == 1) {
      result.add(students.get(0));
    }

    return result;
  }

}
