package com.olegorlov.softserve.jom.sprint06.question5;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class MyUtils {

  private static String staticValue;

  private String instanceValue;

  {
    staticValue = "staticValue";
    instanceValue = "instanceValue";
  }

  public static void main(String[] args) {

    MyUtils utils = new MyUtils();
    utils.method();
  }

  public void method() {
    Set<Predicate<Integer>> predicates = new HashSet<>();
    predicates.add((p) -> true);
    predicates.add((p) -> false);
    predicates.add((p) -> false);
    predicates.add((p) -> false);
    predicates.add((p) -> false);
    predicates.add((p) -> true);

    StringBuilder stringBuilder = new StringBuilder();

    int i = 5;
    predicates.forEach((c) -> {
//      i++;
      stringBuilder.append(c.test(5 + i)).append(" && ");

//      staticValue = "static tutu";
//      instanceValue = "instance tutu";
//      System.out.println(staticValue);
//      System.out.println(instanceValue);
    });
    System.out.println(
        String.format("(%s) = %s",
            stringBuilder.substring(0, stringBuilder.length() - 4), getPredicateFromSet(predicates).test(5)));
  }

  static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> predicates) {
    Predicate<Integer> result = (p) -> true;
    for (Predicate<Integer> predicate : predicates) {
      result = result.and(predicate);
    }
    return result;
  }
}
