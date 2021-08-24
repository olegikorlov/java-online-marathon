package com.olegorlov.softserve.jom.sprint00.uml;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {
    Shape circle = new Circle(new Point(36, 27), 18.25);
    circle.changeColor(218, 68, 194);
    circle.draw();

    Shape rectangle = new Rectangle(new Point(64, 93), 38.75, 45.32);
    rectangle.changeColor(232, 123, 43);
    rectangle.draw();

    Shape square = new Square(new Point(64, 93), 38.75);
    square.changeColor(232, 123, 43);
    square.draw();

  }

}
