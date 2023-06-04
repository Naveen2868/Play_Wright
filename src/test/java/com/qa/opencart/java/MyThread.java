package com.qa.opencart.java;

public class MyThread extends Thread{

    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("From run "+i);
        }
    }
}

class Test1{

    public static void main(String[] args) {

        MyThread t = new MyThread();
        System.out.println(t.getName());
        System.out.println(Thread.currentThread().getName());
        t.start();
        /*for (int i = 0; i < 10; i++) {
            System.out.println("from main "+i);
        }*/

    }
}