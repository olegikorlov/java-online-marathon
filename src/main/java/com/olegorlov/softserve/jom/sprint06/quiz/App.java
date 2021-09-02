package com.olegorlov.softserve.jom.sprint06.quiz;

import java.util.function.BinaryOperator;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {
    Name name = () -> {

    };

    MyFunction binaryOperator = (int x, int y) -> { return x * y; };


    BinaryOperator<Integer> binaryOperator2 = (x, y) -> { return x * y; };


//    BinaryOperator<Integer> binaryOperator = (x, y) ->  return x * y;


//    ( ) -> { return x * y; }


    BinaryOperator<Integer> binaryOperator1 = (x, y) -> x * y;


//    x, y -> x * y;
  }

}

@FunctionalInterface
interface MyFunction {
  int method(int x, int y);
}


@FunctionalInterface
interface Name {

  void method();

}

class NameClass {

  void method1() {

  }
}

@FunctionalInterface
interface Sayable {
  void say(String msg);   // abstract method

  // It can contain any number of Object class methods.
  int hashCode();

  String toString();

  boolean equals(Object obj);
}


