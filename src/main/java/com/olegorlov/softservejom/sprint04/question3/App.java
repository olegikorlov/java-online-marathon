package com.olegorlov.softservejom.sprint04.question3;

import java.util.*;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {
    List<String> list = Arrays.asList("aa", "bb", "aa", "cc");
    Map<String, String> map = new HashMap<>();
    map.put("1", "cc");
    map.put("2", "bb");
    map.put("3", "cc");
    map.put("4", "aa");
    map.put("5", "cc");
//    map.put("6", "dd");

    System.out.println(new App().listMapCompare(list, map));
  }

  public boolean listMapCompare(List<String> list, Map<String, String> map) {

    for (String value : list) {
      if (!map.containsValue(value)) {
        return false;
      }
    }
    return list.containsAll(map.values());

  }

}
