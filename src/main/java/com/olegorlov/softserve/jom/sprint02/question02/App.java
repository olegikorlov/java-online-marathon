package com.olegorlov.softserve.jom.sprint02.question02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {
    Caffee espresso0 = new Espresso(8);
    Caffee cappuccino0 = new Cappuccino(10);
    cappuccino0
        .addComponent("Lemon", 10)
        .addComponent("Koka", 5);
    cappuccino0.makeDrink();
    Caffee espresso1 = new Espresso(10);
    Caffee cappuccino1 = new Cappuccino(6);
    Caffee caffee0 = new Caffee(6);

    List<Caffee> caffees = new ArrayList<>();
    caffees.add(espresso0);
    caffees.add(cappuccino0);
    caffees.add(espresso1);
    caffees.add(cappuccino1);
    caffees.add(caffee0);
    System.out.println(caffees);

    System.out.println(espresso0.makeDrink());

    System.out.println(new MyUtils().averageRating(caffees));
  }
}

interface DrinkReceipt {
  String getName();
  DrinkReceipt addComponent(String componentName, int componentCount);
}

interface DrinkPreparation {
  Map<String, Integer> makeDrink();
}

interface Rating {
  int getRating();
}

class Caffee implements DrinkReceipt, DrinkPreparation, Rating {

  private String name;
  private int rating;
  private Map<String, Integer> ingredients;

  public Caffee(String name, int rating) {
    this.name = name;
    this.rating = rating;
    this.ingredients = new HashMap<>();
    addComponent("Water", 100)
        .addComponent("Arabica", 20);
  }

  public Caffee(int rating) {
    this("Caffee", rating);
  }

  @Override
  public Map<String, Integer> makeDrink() {
    return ingredients;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getRating() {
    return rating;
  }

  @Override
  public DrinkReceipt addComponent(String componentName, int componentCount) {
    ingredients.put(componentName, componentCount);
    return this;
  }

  @Override
  public String toString() {
    return String.format("%s [name=%s, rating=%s]", this.getClass().getSimpleName(), name, rating);
  }

}

class Cappuccino extends Caffee {

  public Cappuccino(String name, int rating) {
    super(name, rating);
  }

  public Cappuccino(int rating) {
    this("Cappuccino", rating);
  }

  @Override
  public Map<String, Integer> makeDrink() {
    addComponent("Milk", 50);
    return super.makeDrink();
  }

}

class Espresso extends Caffee {

  public Espresso(String name, int rating) {
    super(name, rating);
  }

  public Espresso(int rating) {
    this("Espresso", rating);
  }

  @Override
  public Map<String, Integer> makeDrink() {
    addComponent("Water", 50);
    return super.makeDrink();
  }

}

class MyUtils {
  public Map<String, Double> averageRating(List<Caffee> caffees) {
    Map<String , Double> result = new HashMap<>();

    for (Caffee caffee : caffees) {

      final String name = caffee.getName();
      final int rating = caffee.getRating();

      if (result.containsKey(name)) {
        result.put(name, (rating + result.get(name)) / 2);
      } else {
        result.put(name, (double) rating);
      }

    }
    return result;
  }
}
