package com.qa.opencart.java;

public class MyThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Child thread");
            System.out.println(Thread.currentThread().getName());
        }
    }
}

class Test2 {
    public static void main(String[] args) {
        MyThread1 r = new MyThread1();
        Thread t = new Thread(r);
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread");
        }
    }
}