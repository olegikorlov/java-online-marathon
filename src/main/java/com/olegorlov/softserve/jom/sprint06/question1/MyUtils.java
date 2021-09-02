package com.olegorlov.softserve.jom.sprint06.question1;

import java.util.function.Predicate;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class MyUtils {

  public static void main(String[] args) {
//    Function
//    Predicate
//    UnaryOperator
//    BinaryOperator
//    Supplier
//    Consumer
    System.out.println(MyUtils.getCount(new int[]{1, 2, 3, -1, -5, 0}, i -> i > 2));
    System.out.println(MyUtils.getCount(new int[]{1, 2, 3, 4, 5, 10}, i -> i % 2 == 1));
    System.out.println(MyUtils.getCount(new int[]{1, 2, 3, 4, 5, 10}, i -> i > 0 && i < 5));
    System.out.println(MyUtils.getCount(new int[]{}, i -> true));
    System.out.println(MyUtils.getCount(new int[]{1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10}, i -> true));
    System.out.println(MyUtils.getCount(new int[]{1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10}, i -> false));

  }

  public static int getCount(int[] array, Predicate<Integer> predicate) {
    int count = 0;
    for (int value : array) {
      if (predicate.test(value)) {
        count++;
      }
    }
    return count;
  }

}
