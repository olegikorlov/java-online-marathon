package com.olegorlov.softserve.jom.sprint09.selfpreporation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {

  public static void main(String[] args) {

    Method method = null;
    try {
      method = App.class.getMethod("test", int.class);
      Anno anno = method.getAnnotation(Anno.class);
      System.out.println(anno.value());
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
  }

  @Anno(10)
  public static void test(int i) {

  }
}

@Retention(RetentionPolicy.RUNTIME)
@interface Anno {
  int value() default 15;
}

enum TestType {
  R,
  N,
  B;
}

class TestClass implements Interface {
  private int count;

  @AnnatationInAnnatation()
  public TestClass(int count) {
    this.count = count;
  }

  @Override
  public int count() {
    return 0;
  }
}

@FunctionalInterface
interface Interface {
  int count();
}


@interface TestAnnatation {

  int count() default 0;

  int[] array() default 0;

  //  TestClass count4() default 5;
  TestType testEnum() default TestType.N;

  String str() default "5";

  Class<TestClass> clazz() default TestClass.class;

  Class<String> clazz4() default String.class;

  Class clazz1() default TestClass.class;

  Class clazz3() default Object.class;

//  @AnnatationInAnnatation(str = "test in");
}

@interface AnnatationInAnnatation {
  String str() default "test";
}
