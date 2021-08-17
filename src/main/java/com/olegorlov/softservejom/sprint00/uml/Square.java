package com.olegorlov.softservejom.sprint00.uml;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class Square extends Shape {

  private double side;

  public Square(Point point, double side) {
    super(point);
    this.side = side;
  }

  @Override
  protected double perimeter() {
    return 4 * side;
  }

  @Override
  protected double area() {
    return side * side;
  }

}
