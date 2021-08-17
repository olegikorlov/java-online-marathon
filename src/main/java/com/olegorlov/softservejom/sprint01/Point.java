package com.olegorlov.softservejom.sprint01;

import static java.lang.Math.sqrt;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class Point {
  private final int x;
  private final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int[] getXYPair() {
    return new int[]{x, y};
  }

  /**
   * https://www.omnicalculator.com/math/distance#the-distance-formula-for-euclidean-distance
   * @param x
   * @param y
   * @return √[(x₂ - x₁)² + (y₂ - y₁)²]
   */
  public double distance(int x, int y) {
    return sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
  }

  public double distance(Point point) {
    int[] xy = point.getXYPair();
    return distance(xy[0], xy[1]);
  }

  public double distance() {
    return distance(0, 0);
  }

}