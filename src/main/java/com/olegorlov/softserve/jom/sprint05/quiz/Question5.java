package com.olegorlov.softserve.jom.sprint05.quiz;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */

// Compilation error
public class Question5 {
  public static void main(String[] args) {
    MyException exception = new MyException();
//    exception.importentMethod();
  }
}

class MyException extends Exception {

  int imortentData = 5;

  public MyException() {
  }

  public MyException(String message) {
    super(message);
  }

  private void importentMethod() {
    if (imortentData > 5) {
//      throw new MyException("Importent data si invalid");
    } else {
      System.out.println(imortentData);
    }
  }
}
