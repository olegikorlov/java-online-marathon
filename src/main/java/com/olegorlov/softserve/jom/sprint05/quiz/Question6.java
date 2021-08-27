package com.olegorlov.softserve.jom.sprint05.quiz;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class Question6 {
  public static void main(String[] args) {
    try {
      AnotherClass anotherClass = new AnotherClass();
      anotherClass.method1();
      System.out.println("Main compiled");
    } catch (Exception e) {

    }
  }

}

class AnotherClass {
  public void method2() {
    throw new ArrayIndexOutOfBoundsException();
  }

  public void method1() {
    try {
      method2();
    } catch (NullPointerException e) {
      System.out.println("Exception caught");
    } finally {
      System.out.println("Method 1 ends");
    }
  }
}
