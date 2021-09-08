package com.olegorlov.softserve.jom.sprint08.question3;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {
    ThreadExample.threadRun();
  }
}

class Interactor {

  int x;

  public synchronized void serve(UnaryOperator<Integer> uo, int initializer) throws InterruptedException {
    this.x = uo.apply(initializer);
    final String message = "Serving thread %s\n";
    System.out.printf(message, "running");
    System.out.printf(message, "initializes the key");
    System.out.printf("key = %s\n", this.x);
    notify();
    wait();
    System.out.println("Serving thread resumed");
  }

  public synchronized void consume(BinaryOperator<Integer> bo, int operand1) throws InterruptedException {
    wait(3000);
    final String message = "Consuming thread %s the key. key = %d\n";
    System.out.printf(message, "received", this.x);
    this.x = bo.apply(this.x, operand1);
    System.out.printf(message, "changed", this.x);
    notify();
  }
}

class ThreadExample {
  public static void threadRun() {
    Interactor interactor = new Interactor();

    Thread t1 = new Thread(() -> {
      try {
        interactor.serve(x -> -x + 4, 11);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    Thread t2 = new Thread(() -> {
      try {
        interactor.consume((a, b) -> a + 2 * b, 20);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    try {
      t2.start();
      t1.start();
      t2.join();
      t1.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
