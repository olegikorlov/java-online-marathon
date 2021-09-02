package com.olegorlov.softserve.jom.sprint06.selfpreporation;

import java.util.function.*;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {

  public static void main(String[] args) {
    MyInterface i = (value) -> System.out.println(String.format("Hello %s!", value));
    i.print("World");

    Function<Integer, Integer> function = (p) -> p + 9;
    System.out.println(function.apply(1));

    Function<Integer, Integer> five = new AddFive();
    System.out.println(five.apply(6));

    Predicate<Integer> predicate = (p) -> p != null;
    System.out.println(predicate.test(null));
    System.out.println(predicate.test(7));

    Predicate<Integer> predicate1 = new CheckForNull();
    System.out.println(predicate1.test(null));
    System.out.println(predicate1.test(7));

    UnaryOperator<Integer> unaryOperator = (p) -> {
      p += p;
      return p;
    };
    System.out.println(unaryOperator.apply(6));

    BinaryOperator<Integer> binaryOperator = (p1, p2) -> {
      p1 += p2;
      return p1;
    };
    System.out.println(binaryOperator.apply(6, 4));

    Supplier<Integer> integerSupplier = new MySupplier();
    System.out.println(integerSupplier.get());

    Supplier<Integer> supplier = () -> (int) (Math.random() * 100);
    System.out.println(supplier.get());

    Consumer<Integer> consumer = (value) -> System.out.println(value);
    consumer.accept(5);

//    Function
//    Predicate
//    UnaryOperator
//    BinaryOperator
//    Supplier
//    Consumer

  }

}

@FunctionalInterface
interface MyInterface {
  void print(String value);
}

class AddFive implements Function<Integer, Integer> {

  @Override
  public Integer apply(Integer integer) {
    return integer + 5;
  }

}

class CheckForNull implements Predicate<Integer> {

  @Override
  public boolean test(Integer integer) {
    return integer != null;
  }
}

class MySupplier implements Supplier<Integer> {

  @Override
  public Integer get() {
    return (int) (Math.random() * 1000);
  }
}

