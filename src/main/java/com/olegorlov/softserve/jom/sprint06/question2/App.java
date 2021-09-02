package com.olegorlov.softserve.jom.sprint06.question2;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {

  static Consumer<double[]> cons = (array) -> {
    for (int i = 0; i < array.length; i++) {
      if (array[i] > 2.0) {
        array[i] *= 0.8;
      } else {
        array[i] *= 0.9;
      }
    }
  };

  public static double[] getChanged(double[] initialArray, Consumer<double[]> consumer) {
    double[] result = Arrays.copyOf(initialArray, initialArray.length);
    consumer.accept(result);
    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(App.getChanged(new double[]{4.5, 1.2}, App.cons)));

  }
}
