package com.olegorlov.softserve.jom.sprint05.quiz;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */

// T + Exception
public class Question9 {
  public static void m1() throws Exception {
    throw new Exception();
  }

  public static void main(String[] args) throws Exception {
    try {
      m1();
      System.out.println("I");
    } finally {
      System.out.println("T");
    }
    System.out.println("Academy");
  }
}
