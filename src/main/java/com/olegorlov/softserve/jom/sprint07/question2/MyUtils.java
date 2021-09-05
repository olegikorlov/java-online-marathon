package com.olegorlov.softserve.jom.sprint07.question2;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */

/*
Write a method to get the date n-years m-months and k-days after today using new DateTime API.
Return the obtained date in the format ISO_LOCAL_DATE.
*/
public class MyUtils {

  public static void main(String[] args) {
    System.out.println(getDateAfterToday(3, 18, 27));
    System.out.println(getDateAfterToday(-2, 5, 18));
    System.out.println(getDateAfterToday(8, 0, 24));
    System.out.println(getDateAfterToday(2, -37, 9));
    System.out.println(getDateAfterToday(0, 0, 0));
  }

  public static String getDateAfterToday(int years, int months, int days) {
    final Period period = Period.of(years, months, days);
    return LocalDate.now()
        .plus(period)
        .format(DateTimeFormatter.ISO_LOCAL_DATE);
/*
    return LocalDate.now()
        .plusYears(years)
        .plusMonths(months)
        .plusDays(days)
        .format(DateTimeFormatter.ISO_LOCAL_DATE);
*/
  }
}
