package com.olegorlov.softserve.jom.sprint05.quiz;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */

// abdec
public class Question8 {

  private String str = "a";

  void a() {
    try {
      str += "b";
      b();
    } catch (Exception e) {
      str += "c";
    }
  }

  void b() throws Exception {
    try {
      str += "d";
      c();
    } catch (Exception e) {
      throw new  Exception();
    } finally {
      str += "e";
    }
    str += "f";
  }

  void c() throws Exception {
    throw new Exception();
  }

  void display() {
    System.out.println(str);
  }

  public static void main(String[] args) {
    Question8 test = new Question8();
    test.a();
    test.display();
  }
}
