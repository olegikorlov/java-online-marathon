package com.olegorlov.softserve.jom.sprint00.uml;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class Circle extends Shape {

  private double radius;

  public Circle(Point point, double radius) {
    super(point);
    this.radius = radius;
  }

  @Override
  protected double perimeter() {
    return 2 * PI * radius;
  }

  @Override
  protected double area() {
    return PI * radius * radius;
  }
}
