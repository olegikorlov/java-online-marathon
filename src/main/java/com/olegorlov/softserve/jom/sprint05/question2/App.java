package com.olegorlov.softserve.jom.sprint05.question2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {

  public static void main(String[] args) throws ColorException, TypeException {
//    System.out.println(Color.valueOf("ds".toUpperCase()));
//    Plant plant = new Plant("Rare", "WHITE", "First Plant");
    System.out.println(Plant.tryCreatePlant("Rare", "WhITE", "First Plant"));
  }
}

class Plant {

  private Type type;
  private Color color;
  private String name;

  public Plant(String type, String color, String name) throws TypeException, ColorException {
    try {
      this.type = Type.valueOf(type.toUpperCase());
    } catch (Exception e) {
      throw new TypeException(
          String.format("Invalid value %s for field type",
              type)
      );

    }

    try {
      this.color = Color.valueOf(color.toUpperCase());
    } catch (Exception e) {
      throw new ColorException(
          String.format("Invalid value %s for field color",
              color)
      );
    }
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Color getColor() {
    return color;
  }

  public Type getType() {
    return type;
  }

  public static Plant tryCreatePlant(String type, String color, String name) throws ColorException, TypeException {

    try {

      try {
        return new Plant(type, color, name);
      } catch (TypeException e) {
        return new Plant("Ordinary", color, name);
      } catch (ColorException e) {
        return new Plant(type, "Red", name);
      }

    } catch (TypeException | ColorException e) {
      return new Plant("Ordinary", "Red", name);
    }
  }

  @Override
  public String toString() {
    return String.format("{type: %s, color: %s, name: %s}",
        type, color, name);
  }
}

enum Type {
  RARE,
  ORDINARY;
}

enum Color {
  WHITE,
  RED,
  BLUE;
}

class ColorException extends Exception {
  public ColorException(String message) {
    super(message);
  }
}

class TypeException extends Exception {
  public TypeException(String message) {
    super(message);
  }
}
