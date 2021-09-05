package com.olegorlov.softserve.jom.sprint07.question4;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */

/*
Create the method readFile(String filename) that read from file a sequence of bytes in binary format from previous task and return ridable string.
For example, the sequence of 7-bit bytes: 100100011001011101100110110011011110100001
should be represented as text fragment: "Hello!"
*/
public class App {

  public static void main(String[] args) {
    final String text = readFile("data2.txt");
    System.out.println(text);
  }

  public static String readFile(String filename) {
    StringBuilder stringBuilder = new StringBuilder();
    try (FileReader fileReader = new FileReader(filename)) {
      int i;
      while ((i = fileReader.read()) != -1) {
        stringBuilder.append((char) i);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return decodeFrom7Bits(stringBuilder.toString());
  }

  private static String decodeFrom7Bits(String str) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < str.length(); i += 7) {
      String substring = str.substring(i, i + 7);
      char character = (char) Integer.parseInt(substring, 2);
      stringBuilder.append(character);
    }
    return stringBuilder.toString();
  }

/*
  private static String decodeFrom7Bits(String str) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < str.length(); i += 7) {

      final CharSequence subSequence = str.subSequence(i, i + 7);
      int value = 0;
      for (int j = 0; j < subSequence.length(); j++) {
        value += Integer.parseInt(String.valueOf(subSequence.charAt(j))) *
            (int) Math.pow(2, subSequence.length() - 1 - j);
      }
      stringBuilder.append((char) value);
    }
    return stringBuilder.toString();
  }
*/

}
