package com.olegorlov.softservejom.sprint00.uml;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class Rectangle extends Shape {

  private double side1;
  private double side2;

  public Rectangle(Point point, double side1, double side2) {
    super(point);
    this.side1 = side1;
    this.side2 = side2;
  }

  @Override
  protected double perimeter() {
    return 2 * (side1 + side2);
  }

  @Override
  protected double area() {
    return side1 * side2;
  }

}
