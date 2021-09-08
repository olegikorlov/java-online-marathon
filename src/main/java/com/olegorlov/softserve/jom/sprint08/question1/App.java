package com.olegorlov.softserve.jom.sprint08.question1;

import java.util.function.BinaryOperator;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
}

class ParallelCalculator implements Runnable {

  int result;

  private BinaryOperator<Integer> binaryOperator;
  private int operand1;
  private int operand2;

  public ParallelCalculator(BinaryOperator<Integer> binaryOperator, int operand1, int operand2) {

    this.binaryOperator = binaryOperator;
    this.operand1 = operand1;
    this.operand2 = operand2;

  }

  @Override
  public void run() {
    result = binaryOperator.apply(operand1, operand2);
  }

}

class Accountant {

  public static int sum(int x, int y) {

    ParallelCalculator parallelCalculator = new ParallelCalculator(Integer::sum, x, y);
    Thread thread = new Thread(parallelCalculator);
    thread.start();
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return parallelCalculator.result;
  }

}
