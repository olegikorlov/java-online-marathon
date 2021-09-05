package com.olegorlov.softserve.jom.sprint07.question3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
/*
Create the method writeFile(String filename, String text) that write the text to file as sequence of bytes in binary format.
For example, the text fragment : "Hello!"
should be represented in the file as a sequence of 7-bit bytes without spaces between them: 100100011001011101100110110011011110100001
If less than 7 bits are required to represent the character then add to binary sequence leading zeros '0'.
*/
public class App {

  public static void main(String[] args) {
//    writeFile("data1.txt", "Hello!");
    // 1001000 1100101 1101100 1101100 1101111 0100001
    // 1001000 1100101 1101100 1101100 1101111 0100001
    // 1001000 1100101 1101100 1101100 1101111 0100001
    // 1001000 1100101 1101100 1101100 1101111 0100001
    // 1001000 1100101 1101100 1101100 1101111 0100001 0100000 0100000 0101110 0100000 0100000 0101110

    System.out.println(encodeTo7Bits("Hello!"));
//    System.out.println(encodeTo7Bits("Олег"));
/*
    for (int i = 0; i < 45; i++) {
      System.out.printf("%s", (char) i);
    }
*/

//    writeFile("data1.txt", "Example of text for test case #1");
    writeFile("data2.txt", "Example of text for test case #2 Oleg");
//    writeFile("data3.txt", "Example of text for test case #3");

    FileCreator fileCreator = new FileCreator();
    System.out.println(fileCreator.create());
  }

  public static void writeFile(String filename, String text) {

    final String result = encodeTo7Bits(text);

    try(OutputStream writer = new FileOutputStream(filename)) {
      writer.write(result.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
/*

    try (FileWriter writer = new FileWriter(filename)) {
      writer.write(result);
    } catch (IOException e) {
      e.printStackTrace();
    }
*/
  }

  private static String encodeTo7Bits(String text) {
    byte[] bytes = text.getBytes();
//    System.out.println(Arrays.toString(bytes));
    StringBuilder binary = new StringBuilder();
    for (byte b : bytes) {
      String str = Integer.toBinaryString(b);
      for (int i = str.length(); i < 7; i++) {
        str = String.format("0%s", str);
      }
/*
      while (str.length() != 7 && str.length() < 7) {
        str = String.format("0%s", str);
      }
*/
      binary.append(str);
    }
    return binary.toString();
  }

/*
  private static byte[] encodeTo7Bits(String str) {
    byte[] bytes = new byte[str.length() * 7];
    for (int i = 0; i < str.length(); i++) {
      int value = (int) str.charAt(i);
      for (int j = 6; j > -1; j--) {
        if (value % 2 == 1) {
          bytes[i * 7 + j] = 1;
        }
        value /= 2;
      }
    }
    return bytes;
  }
*/

/*
  private static String getString(byte[] array) {
    StringBuilder stringBuilder = new StringBuilder();
    for (byte value : array) {
      stringBuilder.append(value);
    }
    return stringBuilder.toString();
  }
*/

}

class FileCreator {
  public boolean create() {
    String dirName = "/home/oleg/Downloads/TEST";
    String fileName = "data1.txt";

    File directory = new File(dirName);
    System.out.println();
    final boolean isDirectoryExists;
    if (!directory.exists()) {
      isDirectoryExists = directory.mkdir();
    } else {
      isDirectoryExists = true;
    }

    try {

      File file = new File(dirName + File.separator + fileName);
      final boolean isFileExists;
      if (!file.exists()) {
        isFileExists = file.createNewFile();
      } else {
        isFileExists = false;
      }

      if (isFileExists) {
        System.out.println(file.getCanonicalPath());
      } else {
        final boolean delete = file.delete();
      }
      System.out.println(Arrays.toString(directory.list()));

      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }
}
