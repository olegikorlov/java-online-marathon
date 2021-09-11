package com.olegorlov.softserve.jom.sprint09.question2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {
    Util.review(Class1.class.getName());
    Util.review(Class2.class.getName());
    Util.review(Class3.class.getName());
    Util.review("com.olegorlov.softserve.jom.sprint09.question2.Class18");
  }

}

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Review {

  String reviewer();
  String date() default "today";

}

class Util {
  public static void review(String className) {
    try {
      System.out.println(getMessage(Class.forName(className)));
    } catch (ClassNotFoundException e) {
      System.out.printf("Class %s was not found", className);
    }
  }

  private static String getMessage(Class<?> clazz) {
    if (clazz.isAnnotationPresent(Review.class)) {
      final Review review = clazz.getAnnotation(Review.class);
      return String.format("Class %s was reviewed %s by %s.",
          clazz.getName(),
          getDate(review),
          review.reviewer());
    }
    return String.format("Class %s isn't marked as Reviewed",
        clazz.getName());
  }

  private static String getDate(Review review) {
    String date = review.date();
    if (date.equals("today")) {
      return LocalDate.now().toString();
    }
    return date;
  }
}

class Class1 {}

@Review(reviewer = "Only me", date = "2018")
class Class2 {}

@Review(reviewer = "Only me")
class Class3 {}
