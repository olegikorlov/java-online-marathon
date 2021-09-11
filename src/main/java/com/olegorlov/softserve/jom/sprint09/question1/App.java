package com.olegorlov.softserve.jom.sprint09.question1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {
    final boolean b = CheckCamelCase.checkAndPrint(ClassForAnnot.class);
    final boolean b1 = CheckCamelCase.checkAndPrint(Class1.class);
    final boolean b2 = CheckCamelCase.checkAndPrint(Class2.class);
  }
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface CamelCase {
}

class CheckCamelCase {

  public static final String CAMELCASE_PATTERN = "[a-z]+((\\d)|([A-Z0-9][a-z0-9]+))*([A-Z])?";

  public static boolean checkAndPrint(Class clazz) {
    return Arrays.stream(clazz.getDeclaredMethods())
        .filter(method -> method.isAnnotationPresent(CamelCase.class)
            && !Pattern.matches(CAMELCASE_PATTERN, method.getName()))
        .peek(method -> {
              System.out.println(String.format(
                  "method %s.%s doesn't satisfy camelCase naming convention",
                  clazz.getSimpleName(),
                  method.getName())
              );
            }
        )
        .count() == 0;
  }

}

class ClassForAnnot {
  @CamelCase
  public static void example() {
  }

  @CamelCase
  public void Example() {
  }

  public static void _main(String args[]) {
  }
}


class Class1 {
  @CamelCase
  public void correct() {
  }

  @CamelCase
  public void InCorrect() {
  }

  @CamelCase
  public void JustMethod() {
  }
}

class Class2 {
  @CamelCase
  public void correct() {
  }

  @CamelCase
  public void oneMoreCorrect() {
  }
}

