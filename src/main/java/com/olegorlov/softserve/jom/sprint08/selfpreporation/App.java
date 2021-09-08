package com.olegorlov.softserve.jom.sprint08.selfpreporation;

import java.util.Scanner;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
  public static void main(String[] args) {
    MyThread myThread = new MyThread("First");
    myThread.start();

    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();

    myThread.shutdown();

/*
    MyThread myThread2 = new MyThread("Second");
    myThread2.start();
*/

/*
    Thread myThread = new Thread(new Ranner("First"));
    myThread.start();

    Thread myThread2 = new Thread(new Ranner("Second"));
    myThread2.start();
*/

  }
}

class Main {

  public static void main(String[] args) {

    Thread t1 = new App1();
    Thread t2 = new Thread2();
    Thread t3 = new Thread3();

//    Thread t4 = new Thread(new Runner1());
    Thread t5 = new Thread(new Runner2());
    Thread t6 = new Thread(new Runner3());

  }
}

class Object1 {
  public static void main(String[] args) {
    System.out.println("1 ");
    synchronized (args) {
      System.out.println("2 ");
      try {
        args.wait();
      } catch (InterruptedException e) {

      }
    }
    System.out.println("3 ");
  }

/*
  public synchronized void method1() {
    synchronized (this) {
      try {
        notify();
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static synchronized void method2() {
  }
*/
}

class App1 extends Thread {
  public static void main(String[] args) {
    App1 t = new App1();
    t.start();
    System.out.println();
    t.start();
    System.out.println();

  }

  @Override
  public void run() {
    System.out.println("Thread ");
  }
}

class Thread2 extends Thread {
  @Override
  public void run() {
  }
}

class Thread3 extends Thread {
  @Override
  public void run() {
  }
}

class ThreadDemo implements Runnable {
  int x = 0, y =0;

  int addX() {
    x++;
    return x;
  }

  int addY() {
    y++;
    return y;
  }

  @Override
  public void run() {
    for (int i = 0; i< 10; i++){
      System.out.println(Thread.currentThread().getName() + ": " + addX() + " " + addY());
    }
  }

  public static void main(String[] args) {
    ThreadDemo threadDemo = new ThreadDemo();
    ThreadDemo threadDemo1 = new ThreadDemo();
    Thread thread1 = new Thread(threadDemo);
    Thread thread2 = new Thread(threadDemo1);

    thread1.start();
    thread2.start();
  }
}

class Runner2 implements Runnable {
  @Override
  public void run() {
  }
}

class Runner3 implements Runnable {
  @Override
  public void run() {
  }
}


class TestInterruptingThread1 extends Thread {
  public void run() {
    try {
      Thread.sleep(1000);
      System.out.println("task");
    } catch (InterruptedException e) {
      throw new RuntimeException("Thread interrupted..." + e);
    }

  }

  public static void main(String args[]) {
    TestInterruptingThread1 t1 = new TestInterruptingThread1();
    t1.start();
    try {
      t1.interrupt();
    } catch (Exception e) {
      System.out.println("Exception handled " + e);
    }

  }
}

class TestInterruptingThread2 extends Thread {
  public void run() {
    try {
      Thread.sleep(1000);
      System.out.println("task");
    } catch (InterruptedException e) {
      System.out.println("Exception handled " + e);
    }
    System.out.println("thread is running...");
  }

  public static void main(String args[]) {
    TestInterruptingThread2 t1 = new TestInterruptingThread2();
    t1.start();
    t1.interrupt();
  }
}

class TestInterruptingThread4 extends Thread {

  public void run() {
    for (int i = 1; i <= 2; i++) {
      if (Thread.interrupted()) {
        System.out.println("code for interrupted thread");
      } else {
        System.out.println("code for normal thread");
      }

    }
  }

  public static void main(String args[]) {

    TestInterruptingThread4 t1 = new TestInterruptingThread4();
    TestInterruptingThread4 t2 = new TestInterruptingThread4();

    t1.start();
    t1.interrupt();

    t2.start();

  }
}

class Ranner implements Runnable {

  private String name;

  public Ranner(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public void run() {
    new MyThread(getName()).run();
  }

}

class MyThread extends Thread {

  private volatile boolean running = true;

  public MyThread(String name) {
    super(name);
  }

  @Override
  public void run() {
/*
    for (int i = 0; i < 100; i++) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.printf("Hello from %s: %d\n", getName(), i);
    }
*/
    while (running) {
      System.out.println("Hello");
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }

  public void shutdown() {
    this.running = false;
  }

}