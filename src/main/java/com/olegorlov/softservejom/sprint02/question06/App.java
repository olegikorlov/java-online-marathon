package com.olegorlov.softservejom.sprint02.question06;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {
    // [Circle [radius=2.00],
    // Rectangle [height=2.00, width=3.00],
    // Circle [radius=1.00],
    // Rectangle [height=3.00, width=2.00],
    // Circle [radius=0.50],
    // Rectangle [height=1.00, width=2.00]]

    Shape shape0 = new Circle("Circle", 2.00);
    Shape shape1 = new Rectangle("Rectangle", 3.00, 2.00);
    Shape shape2 = new Circle("Circle", 1.00);
    Shape shape3 = new Rectangle("Rectangle", 2.00, 3.00);
    Shape shape4 = new Circle("Circle", 0.50);
    Shape shape5 = new Rectangle("Rectangle", 2.00, 1.00);

    List<Shape> shapes = new ArrayList<>();
    shapes.add(shape0);
    shapes.add(shape1);
    shapes.add(shape2);
    shapes.add(shape3);
    shapes.add(shape4);
    shapes.add(shape5);

    System.out.println(shapes);

    System.out.println(new MyUtils().maxAreas(shapes));
  }
}

abstract class Shape {

  private String name;

  public Shape(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  abstract double getArea();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Shape)) return false;

    Shape shape = (Shape) o;

    return name != null ? name.equals(shape.name) : shape.name == null;
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }

}

class Rectangle extends Shape {

  private double height;
  private double width;

  public Rectangle(String name, double width, double height) {
    super(name);
    this.width = width;
    this.height = height;
  }

  @Override
  public double getArea() {
    return Math.pow((height + width), 2);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Rectangle)) return false;
    if (!super.equals(o)) return false;

    Rectangle rectangle = (Rectangle) o;

    if (Double.compare(rectangle.height, height) != 0) return false;
    return Double.compare(rectangle.width, width) == 0;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    long temp;
    temp = Double.doubleToLongBits(height);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(width);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return String.format("%s [height=%.2f, width=%.2f]",
        getClass().getSimpleName(), getHeight(), getWidth());
  }

  public double getHeight() {
    return height;
  }

  public double getWidth() {
    return width;
  }

}

class Circle extends Shape {

  private double radius;

  public Circle(String name, double radius) {
    super(name);
    this.radius = radius;
  }

  public double getRadius() {
    return radius;
  }

  @Override
  double getArea() {
    return Math.PI * Math.pow(radius, 2);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Circle)) return false;
    if (!super.equals(o)) return false;

    Circle circle = (Circle) o;

    return Double.compare(circle.radius, radius) == 0;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    long temp;
    temp = Double.doubleToLongBits(radius);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return String.format("%s [radius=%.2f]",
        getClass().getSimpleName(), radius);
  }

}

class MyUtils {

  public List<Shape> maxAreas(List<Shape> shapes) {
    if (shapes.isEmpty()) {
      return new ArrayList<>();
    } else if (shapes.size() == 1) {
      return new ArrayList<>(shapes);
    }

    List<Circle> circles = new ArrayList<>();
    List<Rectangle> rectangles = new ArrayList<>();
    List<Shape> result = new ArrayList<>();
    for (Shape shape : shapes) {
      if (shape instanceof Circle) {
        circles.add((Circle) shape);
      } else if (shape instanceof Rectangle) {
        rectangles.add((Rectangle) shape);
      }
    }

    circles.sort(new CircleComparator());
    if (!circles.isEmpty()) {
      result.add(circles.get(0));
    }

    if (rectangles.size() > 1) {
      rectangles.sort(new RectangleComparator());
      Rectangle rectangle0 = rectangles.get(0);
      Rectangle rectangle1 = rectangles.get(1);

      if (rectangle0.getArea() > rectangle1.getArea() ||rectangle0.equals(rectangle1)) {
        result.add(rectangle0);
      } else {
        result.add(rectangle0);
        result.add(rectangle1);
      }

    } else if (rectangles.size() == 1) {
      result.add(rectangles.get(0));
    }
    return result;
  }

  private class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle o1, Circle o2) {
      return Double.compare(o2.getArea(), o1.getArea());
    }
  }

  private class RectangleComparator implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle o1, Rectangle o2) {
      if (Double.compare(o2.getArea(), o1.getArea()) == 0) {
        return Double.compare(o2.getWidth(), o1.getWidth());
      }
      return Double.compare(o2.getArea(), o1.getArea());
    }
  }

}
