package com.olegorlov.softserve.jom.sprint03.question6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {
    AddressBook addressBook = new AddressBook(20);
    addressBook.create("John", "Brown", "Address #1");
    addressBook.create("Susan", "Brown", "Address #4");
    addressBook.create("Karen", "Davis", "Address #2");
    addressBook.create("John", "Taylor", "Address #1");
    addressBook.create("Susan", "Brown", "Address #4");
    addressBook.create("Susan", "Brown", "Address #4");
    addressBook.create("Steven", "Taylor", "Address #3");
    printResult(addressBook);

    addressBook.sortedBy(SortOrder.ASC);
    printResult(addressBook);

    addressBook.sortedBy(SortOrder.DESC);
    printResult(addressBook);

    System.out.println(addressBook.read("Susan", "Brown"));
    System.out.println(addressBook.read("Susan", "Brow"));

    System.out.println(addressBook.update("Steven", "Taylor", "toto"));
    System.out.println(addressBook.update("Steven", "Tayl", "toto"));
    printResult(addressBook);


    System.out.println(addressBook.delete("Susan", "Brown"));
    System.out.println(addressBook.delete("John", "Tayl"));
    printResult(addressBook);

    for (Object record : addressBook) {
      System.out.println(record + "gggg");
    }
  }

  private static void printResult(AddressBook addressBook) {
    final Iterator iterator = addressBook.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    System.out.println();
  }
}

enum SortOrder {
  ASC,
  DESC;
}

class AddressBook implements Iterable {

  private NameAddressPair[] addressBook;
  private int counter = 0;

  public AddressBook(int capacity) {
    this.addressBook = new NameAddressPair[capacity];
  }

  public boolean create(String firstName, String lastName, String address) {

    if (addressBook.length < counter + 1) {
      addressBook = Arrays.copyOf(addressBook, addressBook.length * 2);
    }

    final NameAddressPair nameAddressPairToCreate = new NameAddressPair(
        new NameAddressPair.Person(firstName, lastName), address);

    for (int i = 0; size() > i; i++) {
      if (compareByNameAddressPair(addressBook[i], nameAddressPairToCreate) == 0) {
        return false;
      }
    }

    addressBook[counter] = nameAddressPairToCreate;
    counter++;
    return true;

  }

  public String read(String firstName, String lastName) {

    final NameAddressPair nameAddressPairToRead = new NameAddressPair(
        new NameAddressPair.Person(firstName, lastName), "");

    for (int i = 0; size() > i; i++) {
      if (compareByNameAddressPair(addressBook[i], nameAddressPairToRead) == 0) {
        return addressBook[i].address;
      }
    }
    return null;

  }

  public boolean update(String firstName, String lastName, String address) {

    final NameAddressPair nameAddressPairToUpdate = new NameAddressPair(
        new NameAddressPair.Person(firstName, lastName), address);

    for (int i = 0; size() > i; i++) {
      if (compareByNameAddressPair(addressBook[i], nameAddressPairToUpdate) == 0) {
        addressBook[i] = nameAddressPairToUpdate;
        return true;
      }
    }
    return false;

  }

  public boolean delete(String firstName, String lastName) {

    final NameAddressPair nameAddressPairToUpdate = new NameAddressPair(
        new NameAddressPair.Person(firstName, lastName), "");

    for (int i = 0; size() > i; i++) {
      if (compareByNameAddressPair(addressBook[i], nameAddressPairToUpdate) == 0) {
        System.arraycopy(addressBook, i + 1, addressBook, i, size() - i - 1);
        counter--;
        return true;
      }
    }
    return false;

  }

  public int size() {
    return counter;
  }

  public void sortedBy(SortOrder order) {

    if (order.equals(SortOrder.DESC)) {
      Arrays.sort(addressBook, 0, size(), new Comparator<NameAddressPair>() {
        @Override
        public int compare(NameAddressPair o1, NameAddressPair o2) {
          return compareByNameAddressPair(o1, o2);
        }
      });
    } else if (order.equals(SortOrder.ASC)) {
      Arrays.sort(addressBook, 0, size(), new Comparator<NameAddressPair>() {
        @Override
        public int compare(NameAddressPair o1, NameAddressPair o2) {
          return compareByNameAddressPair(o2, o1);
        }
      });
    }

  }

  private int compareByNameAddressPair(NameAddressPair o1, NameAddressPair o2) {
    if (o2.person.firstName.compareTo(o1.person.firstName) == 0) {
      return o2.person.lastName.compareTo(o1.person.lastName);
    }
    return o2.person.firstName.compareTo(o1.person.firstName);
  }

  @Override
  public Iterator iterator() {
    return new AddressBookIterator();
  }

  private class AddressBookIterator implements Iterator {

    private int counter = 0;

    @Override
    public boolean hasNext() {
      return size() > counter;
    }

    @Override
    public String next() {
      final NameAddressPair nameAddressPair = addressBook[counter];
      final NameAddressPair.Person person = nameAddressPair.person;
      counter++;
      return String.format("First name: %s, Last name: %s, Address: %s",
          person.firstName, person.lastName, nameAddressPair.address);
    }
  }

  private static class NameAddressPair {

    private final Person person;
    private final String address;

    private NameAddressPair(Person person, String address) {
      this.person = person;
      this.address = address;
    }

    private static class Person {

      private final String firstName;
      private final String lastName;

      private Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        return lastName != null ? lastName.equals(person.lastName) : person.lastName == null;
      }

      @Override
      public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
      }
    }

  }

}
