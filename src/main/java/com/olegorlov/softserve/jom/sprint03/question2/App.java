package com.olegorlov.softserve.jom.sprint03.question2;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {
    NameList nameList = new NameList();
    NameList.Iterator iterator = nameList.getIterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}

class NameList {
  private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};

  public Iterator getIterator() {
    return new Iterator();
  }

  public class Iterator {

    private int counter = 0;

    private Iterator() {
    }

    public boolean hasNext() {
      return names.length > counter;
    }

    public String next() {
      counter++;
      return names[counter - 1];

    }
  }

  // Write your code here

}