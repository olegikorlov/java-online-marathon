package com.olegorlov.softservejom.sprint03.question4;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {
    System.out.println(drawLine(LineType.SOLID));
    System.out.println(drawLine(LineType.DOTTED));
    System.out.println(drawLine(LineType.DASHED));
    System.out.println(drawLine(LineType.DOUBLE));
  }

  enum LineType {
    SOLID,
    DOTTED,
    DASHED,
    DOUBLE;
  }

  public static String drawLine(LineType lineType) {
    return String.format("The line is %s type", lineType.name().toLowerCase());
  }

}
