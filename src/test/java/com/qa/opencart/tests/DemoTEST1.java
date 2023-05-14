package com.qa.opencart.tests;


public class DemoTEST1 {

    public static void main(String[] args){
        String s = "Order Number: 1433134";
        s = s.replaceAll("\\D+","");
        System.out.println(s);
    }
}
