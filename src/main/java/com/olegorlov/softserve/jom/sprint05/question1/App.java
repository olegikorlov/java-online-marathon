package com.olegorlov.softserve.jom.sprint05.question1;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {
    System.out.println(Operation.trySquareRectangle(1, 87));
    System.out.println(Operation.trySquareRectangle(0, 5));
    System.out.println(Operation.trySquareRectangle(1, -5));
    System.out.println(Operation.trySquareRectangle(0, 5));
    System.out.println(Operation.trySquareRectangle(3, 2));
    System.out.println(Operation.trySquareRectangle(-2, -8));
  }

}

class Operation {
  public static int squareRectangle(int a, int b) throws IllegalArgumentException {
    if (a < 1 || b < 1) {
      throw new IllegalArgumentException("both arguments should be more than zero");
    }
    return a * b;
  }

  public static int trySquareRectangle(int a, int b) {
    try {
      return squareRectangle(a, b);
    } catch (IllegalArgumentException e) {
      return -1;
    }
  }
}
