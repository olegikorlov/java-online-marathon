package com.olegorlov.softserve.jom.sprint06.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {

  public static void main(String[] args) {
    Person person = new Person("Oleg");
    Shop shop = new Shop();
    shop.clients.add(person.goShopping);
    System.out.println(shop.sale("product1", 11));
  }
}

class Person {

  String name;

  Person(String name) {
    this.name = name;
  }

  DecisionMethod goShopping =
      (productName, discount) -> "product1".equals(productName) && discount > 10;

}

@FunctionalInterface
interface DecisionMethod {
  boolean decide(String productName, int discount);
}

class Shop {
  public List<DecisionMethod> clients = new ArrayList<>();

  public int sale(String product, int percent) {

    int count = 0;

    for (DecisionMethod decisionMethod : clients) {
      if (decisionMethod.decide(product, percent)) {
        count++;
      }
    }

    return count;

  }
}
