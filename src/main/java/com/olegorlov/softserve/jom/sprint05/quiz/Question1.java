package com.olegorlov.softserve.jom.sprint05.quiz;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class Question1 {
  public static void main(String[] args) {
    Parrent a = new Child();
    ((Child) a).m();
  }
}

class Parrent {
  protected void m() throws Exception {
  }
}

class Child extends Parrent {

  @Override
  public void m() {
  }
}
