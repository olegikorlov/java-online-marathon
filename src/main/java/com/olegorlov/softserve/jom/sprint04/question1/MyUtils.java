package com.olegorlov.softserve.jom.sprint04.question1;

import java.util.*;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class MyUtils {

  public static void main(String[] args) {
    Map<String, String> phones = new HashMap<>();
//    {0967654321=Petro, 0677654321=Petro, 0501234567=Ivan, 0970011223=Stepan, 0631234567=Ivan}
    phones.put("0967654321", "Petro");
    phones.put("0677654321", "Petro");
    phones.put("0501234567", "Ivan");
    phones.put("0970011223", "Stepan");
    phones.put("0631234567", "Ivan");

    System.out.println(new MyUtils().createNotebook(phones));
  }

  public Map<String, List<String>> createNotebook(Map<String, String> phones) {

    Map<String, List<String>> result = new HashMap<>();

    for (Map.Entry<String, String> entry : phones.entrySet()) {

      final List<String> numbers;

      final String name = entry.getValue();
      if (result.containsKey(name)) {
        numbers = result.get(name);
      } else {
        numbers = new ArrayList<>();
        result.put(name, numbers);
      }
      numbers.add(entry.getKey());

    }

    return result;

  }

/*
  public Map<String, List<String>> createNotebook(Map<String, String> phones) {

    Map<String, List<String>> result = new HashMap<>();

    Iterator<Map.Entry<String, String>> iterator = phones.entrySet().iterator();

    while (iterator.hasNext()) {
      Map.Entry<String, String> entry = iterator.next();
      final List<String> numbers;

      final String name = entry.getValue();
      if (result.containsKey(name)) {
        numbers = result.get(name);
      } else {
        numbers = new ArrayList<>();
      }
      numbers.add(entry.getKey());
      result.put(name, numbers);
    }

    return result;

  }
*/

}