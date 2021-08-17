package com.olegorlov.softservejom.sprint00.uml;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public abstract class Shape implements Drawable {

  private Point point;
  private Color color;

  public Shape(Point point) {
    this.point = point;
    this.color = new Color(0, 0, 0);
  }

  @Override
  public void draw() {
    System.out.printf("Drawing %s...%nPerimeter is %s%nArea is %s%n",
        this.getClass().getSimpleName(), perimeter(), area());
  }

  public void changeColor(int r, int g, int b) {
    this.color = new Color(r, g, b);
  }

  abstract protected double perimeter();

  abstract protected double area();

}
