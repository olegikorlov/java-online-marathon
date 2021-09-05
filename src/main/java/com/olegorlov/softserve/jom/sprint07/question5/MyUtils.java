package com.olegorlov.softserve.jom.sprint07.question5;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
/*
Let the key of Map is project name and value contains list of participants.
Create a Stream<String> nameList(Map<String, Stream<String>> map) method of the MyUtils class to build sorted
stream of all participants without duplication.
Please ignore null or empty strings, extra spaces and case sensitivity.
Throw NullPointerException if map is null.
For example, for a given map
{"Desktop"=[" iVan", "PeTro ", " Ira "], "Web"=["STepan", "ira ", " Andriy ", "an na"], "Spring"=["Ivan", "Anna"]}
you should get
["Andriy", "Anna", "Ira", "Ivan", "Petro ", "Stepan"]
*/
public class MyUtils {

  public static void main(String[] args) {
    Map<String, Stream<String>> map = new HashMap<>();
    map.put("Desktop", Stream.of(" iVan", "PeTro ", " Ira "));
    map.put("Web", Stream.of("STepan", "ira ", " Andriy ", "an na"));
    map.put("Spring", Stream.of("Ivan", "Anna"));
    MyUtils myUtils = new MyUtils();
    System.out.println(myUtils.nameList(map).collect(Collectors.toList()));

  }

  public Stream<String> nameList(Map<String, Stream<String>> map) {
    if (map.isEmpty()) {
      throw new NullPointerException();
    }

    return map.values()
        .stream()
        .flatMap(f -> f)
        .filter(s -> s != null && !s.trim().isEmpty())
        .map(spaces -> spaces.replaceAll("\\s", ""))
        .map(str -> str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase())
        .distinct()
        .sorted();
  }
}
