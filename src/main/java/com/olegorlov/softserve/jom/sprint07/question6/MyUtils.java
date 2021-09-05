package com.olegorlov.softserve.jom.sprint07.question6;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class MyUtils {
  public static void main(String[] args) {

    List<Stream<String>> list = Arrays.asList(
        Stream.of("093 987 65 43", "(050)1234567", "12-345"),
        Stream.of("067-21-436-57", "050-2345678", "0939182736", "224-19-28"),
        Stream.of("(093)-11-22-334", "044 435-62-18", "721-73-45")
    );

    MyUtils myUtils = new MyUtils();
    final Map<String, Stream<String>> phoneNumbers = myUtils.phoneNumbers(list);
    StringBuilder stringBuilder = new StringBuilder();
    phoneNumbers.forEach((key, value) -> {
      stringBuilder.append(String.format("\"%s\"=%s, ",
          key,
          value.map(s -> String.format("\"%s\"", s)).collect(Collectors.toList())));
    });
    System.out.println(
        String.format("{%s}", stringBuilder.substring(0, stringBuilder.length() - 2))
    );
  }

  public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
    return list.stream()
        .filter(stream -> stream != null)
        .flatMap(phoneNumber -> phoneNumber)
        .filter(phoneNumber -> phoneNumber != null)
        .map(phoneNumber -> phoneNumber.replaceAll("[^\\d.]", ""))
        .filter(phoneNumber -> !phoneNumber.isEmpty())
        .distinct()
        .collect(Collectors.groupingBy(
            phoneNumber -> {
              if (phoneNumber.length() == 10) {
                return phoneNumber.substring(0, 3);
              } else if (phoneNumber.length() == 7) {
                return "loc";
              }
              return "err";
            }, Collectors.mapping(
                phoneNumber -> {
                  if (phoneNumber.length() == 10) {
                    return phoneNumber.substring(3);
                  }
                  return phoneNumber;
                }, Collectors.collectingAndThen(
                    Collectors.toList(),
                    phoneNumberList -> phoneNumberList.stream().sorted()
                )
            )));
  }

}
