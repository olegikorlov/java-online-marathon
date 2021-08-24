package com.olegorlov.softserve.jom.sprint03.question5;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {

    print(productPriceWithDiscount(1625.35, ClientType.NEW));
    print(productPriceWithDiscount(1625.35, ClientType.SILVER));
    print(productPriceWithDiscount(1625.35, ClientType.GOLD));
    print(productPriceWithDiscount(1625.35, ClientType.PLATINUM));
  }

  static void print(double value) {
    System.out.println(String.format("%.2f", value));
  }

  static double productPriceWithDiscount(double price, ClientType clientType) {
    return price * clientType.discount();
  }

}

enum ClientType {

  NEW(1) {
    @Override
    public double discount() {
      return 1;
    }
  },
  SILVER(12) {
    @Override
    public double discount() {
      return (100 - super.months * 0.25) / 100;
    }
  },
  GOLD(30) {
    @Override
    public double discount() {
      return (100 - super.months * 0.3) / 100;
    }
  },
  PLATINUM(60) {
    @Override
    public double discount() {
      return (100 - super.months * 0.35) / 100;
    }
  };

  private int months;

  ClientType(int months) {
    this.months = months;
  }

  abstract double discount();
}
