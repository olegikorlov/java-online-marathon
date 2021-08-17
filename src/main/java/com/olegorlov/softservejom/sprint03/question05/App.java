package com.olegorlov.softservejom.sprint03.question05;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {

    List<Figure> list = new ArrayList<>();
    list.add(new Square(4.00));
    list.add(new Square(5.00));
    list.add(new Rectang(2.00, 3.00));

    System.out.println(new MyUtils().sumPerimeter(list));

  }
}

interface Figure {
  double getPerimeter();
}

class Rectang extends Square implements Figure {

  private double height;

  public Rectang(double width, double height) {
    super(width);
    this.height = height;
  }

  @Override
  public double getPerimeter() {
    return (height + getWidth()) * 2;
  }

  @Override
  public String toString() {
    return String.format("%s [height=%s, width=%s]",
        getClass().getSimpleName(), getHeigh(), getWidth());

  }

  public double getHeigh() {
    return height;
  }

}

class Square implements Figure {

  private double width;

  public Square(double width) {
    this.width = width;
  }

  public double getWidth() {
    return width;
  }

  public double getPerimeter() {
    return width * 4;
  }

  @Override
  public String toString() {
    return String.format("%s [width=%s]",
        getClass().getSimpleName(), getWidth());
  }
}

class MyUtils {

  public double sumPerimeter(List<Figure> figures) {
    double result = 0;
    for (Figure figure : figures) {
      if (figure != null) {
        result += figure.getPerimeter();
      }
    }
    return result;
  }
}