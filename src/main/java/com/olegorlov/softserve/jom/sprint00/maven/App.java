package com.olegorlov.softserve.jom.sprint00.maven;

import org.joda.time.LocalDateTime;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {
    LocalDateTime localDate = LocalDateTime.now();
    System.out.println("Hello World");
    System.out.printf("%s%n", localDate);
  }
}
