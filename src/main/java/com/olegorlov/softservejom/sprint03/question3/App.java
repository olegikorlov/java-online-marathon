package com.olegorlov.softservejom.sprint03.question3;

import jdk.nashorn.internal.objects.annotations.Function;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {
    App.addAtoB(6, 3);
    App.subtractBfromA(6, 3);
    App.multiplyAbyB(6, 3);
    App.divideAbyB(6, 3);
  }

  Strategy strategy = (a, b) -> a + b;

  private static void execute(int a, int b, Strategy strategy) {
    double result = strategy.doOperation(a, b);
    System.out.println(result);
  }

  public static void addAtoB(int a, int b) {
    execute(a, b, new Strategy() {
      @Override
      public double doOperation(int a, int b) {
        return a + b;
      }
    });
  }

  public static void subtractBfromA(int a, int b) {
    execute(a, b, new Strategy() {
      @Override
      public double doOperation(int a, int b) {
        return a - b;
      }
    });
  }

  public static void multiplyAbyB(int a, int b) {
    execute(a, b, new Strategy() {
      @Override
      public double doOperation(int a, int b) {
        return a * b;
      }
    });
  }

  public static void divideAbyB(int a, int b) {
    execute(a, b, new Strategy() {
      @Override
      public double doOperation(int a, int b) {
        return a / b;
      }
    });
  }

}

@FunctionalInterface
interface Strategy {

  double doOperation(int a, int b);

}


