package com.olegorlov.softserve.jom.sprint04.question4;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {

    Integer[] numbers = new Integer[3];
    int numberFromSecondPosition = ArrayUtil.<Integer> setAndReturn(numbers, 52, 1);
    System.out.println(numberFromSecondPosition);

    String[] words = new String[3];
    String stringFromSecondPosition = ArrayUtil.<String> setAndReturn(words, "Hello", 1);
    System.out.println(stringFromSecondPosition);

  }
}

class ArrayUtil {

  public static <T> T setAndReturn(T[] array, T value, int position) {
    array[position] = value;
    return array[position];
  }

}