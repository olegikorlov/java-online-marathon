package com.olegorlov.softserve.jom.sprint07.question1;

import java.time.Year;
import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */

/*

Write a method to check if a year is a leap year or not, using for this the LocalDate class.
If a year is leap then method should return true, otherwise - false.

*/
public class App {

  public static void main(String[] args) {
    int years[] = {1952, 1974, 2020, 2000, 1900};
    IntConsumer consumer = (y) -> {
      System.out.println(String.format("Is a %s year a leap: %s", y, isLeapYear(y)));
    };
    Arrays.stream(years).forEach(consumer);
  }


  public static boolean isLeapYear(int year) {

    return Year.isLeap(year);

/*
    LocalDate localDate = LocalDate.of(year, Month.AUGUST, 1);
    return localDate.isLeapYear();
*/

  }
}
