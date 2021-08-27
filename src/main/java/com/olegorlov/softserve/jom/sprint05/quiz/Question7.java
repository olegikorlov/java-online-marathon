package com.olegorlov.softserve.jom.sprint05.quiz;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */

// SecondException will be thrown as a result of excecution
public class Question7 {

  public static void do1() throws FirstException {
    throw new FirstException();
  }

  public static void do2() throws SecondException {
    throw new SecondException();
  }

  public static void main(String[] args) throws Exception {
    try {
      do1();
    } finally {
      do2();
    }
  }
}

class FirstException extends Exception { }
class SecondException extends Exception { }

