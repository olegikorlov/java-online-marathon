package com.olegorlov.softserve.jom.sprint07.selfpreporation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.*;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {

  public static void main(String[] args) {
    App app = new App();
//    app.test();
    app.streamTest();
  }


  private void streamTest() {
    System.out.println(
        Stream.of(3, 2, 1)
            .peek(x -> System.out.print(x))
            .reduce((acc, x) -> acc + x)
            .orElse(0)
    );

    System.out.println(
        Stream.iterate(0, x -> x + 3)
            .limit(4)
            .map(x -> String.valueOf(x))
            .collect(Collectors.joining(", "))
    );

    Random random = new Random();
    Stream.generate(() -> random.nextInt(7))
        .limit(4)
        .forEach(System.out::println);

    System.out.println(
        Stream.generate(() -> random.nextInt(7))
            .limit(4)
            .max(Comparator.naturalOrder())
            .orElse(6)
    );

    Stream.of(1, 12, 2, 3, 2, 21)
        .filter(i -> i > 1)
        .map(i -> String.valueOf(i))
        .collect(Collectors.toCollection(TreeSet::new))
        .forEach(System.out::print);

    System.out.println();
    Stream.of(
        Stream.of(1, 2, 3, 4, 5)
            .sorted(Comparator.reverseOrder())
            .limit(4)
            .reduce(0, (acc, x) -> acc + x)
        , 0)
        .forEach(System.out::println);

    System.out.println();
    String[] array = {"ab", "bad", "ab", "abc"};
    Arrays.stream(array)
        .map(s -> s.split(""))
//        .peek(x -> System.out.print(Arrays.toString(x)))
        .flatMap(Arrays::stream)
//        .peek(x -> System.out.print(Arrays.toString(x.toCharArray())))
        .distinct()
        .collect(Collectors.toList())
        .forEach(System.out::print);

    System.out.println();
    Stream.concat(DoubleStream.of(1).boxed(), IntStream.of(2).boxed())
        .map(Object::getClass)
        .forEach(x -> System.out.print(x.getSimpleName() + ", "));
//        .forEach(System.out::print);

    System.out.println();
    DoubleStream.of((int) 0, 1)
        .boxed()
        .map(Object::getClass)
        .forEach(x -> System.out.print(x.getSimpleName() + ", "));
//        .forEach(System.out::print);

    System.out.println();
    Stream.of(2, 3, 0, 1)
        .flatMapToInt(x -> IntStream.range(0, x))
        .forEach(System.out::print);

    System.out.println();
    Stream.of(2, 3, 0, 1)
        .map(num -> IntStream.range(0, num))
        .forEach(obj -> System.out.print(Arrays.toString(obj.toArray())));
//        .forEach(stream -> stream.forEach(x -> System.out.print(x + ", ")));

    System.out.println();
    int sum = Arrays.stream(new int[]{1, 2, 3, 4})
        .map(i -> i * 2)
        .filter(i -> i > 2)
        .limit(2)
        .sum();
    System.out.println(sum);

    List<List<String>> table = new ArrayList<>();
    table.add(Arrays.asList("1", "2", "3"));
    table.add(Arrays.asList("4", "5"));
    table.stream()
        .limit(1)
        .flatMap(x -> x.stream())
//        .map(list -> list.stream())
//        .skip(1)
//        .forEach(stream -> stream.forEach(System.out::print));
        .forEach(System.out::print);

    System.out.println();
//    IntStream integerStream = IntStream.generate(() -> (int) (Math.random() * 100)).limit(10);
    IntStream integerStream = IntStream.generate(() -> random.nextInt(100)).limit(10);
    final List<Integer> integerList = integerStream
        .boxed()
        .collect(Collectors.toList());
    System.out.println(integerList);

    LongStream longStream = LongStream.range(0, 30);
    final String collect = longStream
        .boxed()
        .map(l -> String.valueOf(l))
        .collect(Collectors.joining(", "));
    System.out.println(collect);

    final List<String> list = Arrays.asList("7", "7", "7", "7", "7");
    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    for (String string : list) {
      System.out.println(string);
    }

    list.forEach(System.out::println);

    Stream<String> stringStream = list.stream();
    final String[] strings = {"sdf", "sdf", "sdf", "sdf"};
    Stream<String> stringStream1 = Arrays.stream(new String[]{"sdf", "sdf", "sdf", "sdf"});
    Stream<String> stringStream2 = Stream.of("sdf", "sdf", "sdf", "sdf");
    Stream<String> stringStream3 = Stream.of(strings);

  }

  private void test() {

/*
    Calendar calendar = GregorianCalendar.getInstance();
    calendar.set(Calendar.YEAR, 2017);
    calendar.set(Calendar.MONTH, 12);
    calendar.set(Calendar.DAY_OF_MONTH, 8);

    System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    System.out.println(calendar.get(Calendar.MONTH));
    System.out.println(calendar.get(Calendar.YEAR));

    LocalDate localDate = LocalDate.of(2017, Month.NOVEMBER, 8);
    localDate.plusYears(2).plusMonths(3).plusDays(4);
    System.out.println(localDate);

    LocalDateTime localDate = LocalDateTime.of(2017, 11, 26, 15, 38);
    Period period = Period.ofYears(1).ofMonths(2).ofDays(3);
    localDate = localDate.minus(period);
    System.out.println(localDate);

    String str = localDate.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
//    localDate = localDate.plus(48, ChronoUnit.HOURS);
    System.out.println(str);
    LocalDateTime localDateTime = LocalDateTime.now();
    LocalDateTime localDateTime = new LocalDateTime(2017, Month.NOVEMBER, 8, 15, 38);
    LocalDateTime localDateTime = LocalDateTime.of(2017, Month.NOVEMBER, 8);
    LocalDateTime localDateTime = LocalDateTime.of(2017, Month.NOVEMBER, 8, 15, 38);
*/

    Date date1 = Calendar.getInstance().getTime();
    System.out.println(date1);
    System.out.println(date1.getTime()); // long milliseconds since January 1st 1970

    Date date2 = new Date();
    date2.setTime(1630744855698L);
    System.out.printf("Is date1 after date2: %s\n",
        date1.after(date2)
    );
    System.out.printf("Is date2 before date1: %s\n",
        date2.before(date1)
    );
    System.out.printf("Compare date1 to date2: %s\n",
        date1.compareTo(date2)
    );


    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, 2020);
//    calendar.set(Calendar.MONTH, Month.FEBRUARY.getValue()); // 1 = February
    calendar.set(Calendar.MONTH, 1); // 1 = February
    calendar.set(Calendar.DAY_OF_MONTH, 5);
    calendar.set(Calendar.HOUR_OF_DAY, 5); // 24 hour clock
    calendar.set(Calendar.MINUTE, 7);

// get date components
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
    int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
    int minute = calendar.get(Calendar.MINUTE);
    int second = calendar.get(Calendar.SECOND);

    System.out.printf("%02d-%02d-%d %02d:%02d:%02d\n",
        dayOfMonth, month, year, hourOfDay, minute, second);

//add one day
    calendar.add(Calendar.DAY_OF_MONTH, 1);
    Date date = calendar.getTime();
    System.out.println(date);

//    DateFormat dateFormat = new SimpleDateFormat();
    DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm", new Locale("uk", "UKR"));
    System.out.println(dateFormat.format(date1));

    LocalDate birthday = LocalDate.of(1982, Month.NOVEMBER, 1);
    LocalDate nextBDay = birthday.withYear(Year.now().getValue());
    System.out.println(nextBDay);

    final Period period = Period.of(1, 1, 1);
    System.out.println(period);

    final Duration duration = Duration.ofHours(10);
    System.out.println(duration);

    final DateTimeFormatter dateTimeFormatter =
        DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm", new Locale("uk", "UKR"));
    LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println(localDateTime.format(dateTimeFormatter));

//    Clock clock = Clock.fixed(Instant.now(), ZoneId.of("+05:00"));
    Clock clock = Clock.system(ZoneId.of("Europe/Kiev"));
    ZonedDateTime zonedDateTime = ZonedDateTime.now(clock);
//    Clock clock = Clock.systemUTC();
    System.out.printf("Clock: %s\n", zonedDateTime.format(dateTimeFormatter));
    Clock clock1 = Clock.offset(clock, duration);
    System.out.println(clock1.instant());

    LocalDate localDate = LocalDate.now();
    int localDateYear = localDate.getYear();
    Month localDateMonth = localDate.getMonth();
    int localDateDayOfMonth = localDate.getDayOfMonth();
    int localDateDayOfYear = localDate.getDayOfYear();
    DayOfWeek localDateDayOfWeek = localDate.getDayOfWeek();

    System.out.println("Year: " + localDateYear);
    System.out.println("Month: " + localDateMonth);
    System.out.println("Day of Month: " + localDateDayOfMonth);
    System.out.println("Day of Year: " + localDateDayOfYear);
    System.out.println("Day of Week: " + localDateDayOfWeek);

    localDate = localDate.minusYears(2);
    localDate = localDate.plusMonths(5);
    localDate = localDate.minusDays(132);
    localDate = localDate.plusWeeks(4);
    System.out.println(localDate);

//    LocalTime localTime = LocalTime.now();
    LocalTime localTime = LocalTime.of(13, 0);
    System.out.println(localTime);

    final Duration duration1 = ChronoUnit.MONTHS.getDuration();
    System.out.println(duration1);
    Clock clock2 = Clock.offset(clock, duration1);
    System.out.println(clock2.instant());

  }
}
