package com.olegorlov.softserve.jom.sprint07.question7;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
/*
Create a Stream<Integer> duplicateElements(Stream<Integer> stream) method of the MyUtils class to return
a sorted stream of duplicated elements of the input stream.
For example, for a given elements
[3, 2, 1, 1, 12, 3, 8, 2, 4, 2]
you should get
[1, 2, 3]
*/
public class MyUtils {

  public static void main(String[] args) {

    MyUtils myUtils = new MyUtils();

    List<Integer> list = Arrays.asList(3, 2, 1, 1, 12, 3, 8, 2, 4, 2);
    System.out.println(myUtils.duplicateElements(list.stream()).collect(Collectors.toList()));

  }

  public Stream<Integer> duplicateElements(Stream<Integer> stream) {
    return stream
        .filter(v -> v != null)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream()
        .filter(v -> v.getValue() > 1)
        .map(v -> v.getKey())
        .sorted();
  }
/*
  public Stream<Integer> duplicateElements(Stream<Integer> stream) {
    Set<Integer> items = new HashSet<>();
    return stream
        .filter(v -> v != null)
        .filter(n -> !items.add(n))
        .collect(Collectors.toSet())
        .stream()
        .sorted();
  }
*/
}
