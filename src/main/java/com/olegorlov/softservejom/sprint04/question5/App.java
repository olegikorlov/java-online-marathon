package com.olegorlov.softservejom.sprint04.question5;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {

  public static void main(String[] args) {

    Array<Integer> set1 = new Array<>(new Integer[]{1, 2, 4, 5});
    double averageValue1 = ArrayUtils.averageValue(set1);
    System.out.println(averageValue1);

    Array<Double> set2 = new Array<>(new Double[]{1.0, 3.0, 5.0, 1.0});
    double averageValue2 = ArrayUtils.averageValue(set2);
    System.out.println(averageValue2);

  }

}

class ArrayUtils {
  public static <T extends Number> double averageValue(Array<T> set) {
    double sum = 0.0;
    for (int i = 0; set.length() > i; i++) {
      sum += set.get(i).doubleValue();
    }
    return sum / set.length();
  }
}

class Array<T> {

  private T[] array;

  public Array(T[] array) {
    this.array = array;
  }

  public T get(int index) {
    return array[index];
  }

  public int length() {
    return array.length;
  }

}