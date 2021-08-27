package com.olegorlov.softserve.jom.sprint05.quiz;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class Question2 {
  public static void main(String... args) {
    ParrentTest object = new ChildTest();
//    object.test();
  }
}

class ParrentTest {
  public void test() throws Exception {
    System.out.println("From parent test");
  }
}

class ChildTest extends ParrentTest {

  @Override
  public void test() {
    System.out.println("From child test");
  }
}
