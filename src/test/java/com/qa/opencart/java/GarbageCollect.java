package com.qa.opencart.java;

import java.util.Date;

public class GarbageCollect {

    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();

        System.out.println(runtime.totalMemory());
        System.out.println(runtime.freeMemory());

        for (int i = 0; i < 100000; i++) {
            Date date = new Date();
            date = null;
        }
        System.out.println(runtime.freeMemory());
        runtime.gc();
        System.out.println(runtime.freeMemory());
    }
}
