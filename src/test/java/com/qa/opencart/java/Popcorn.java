package com.qa.opencart.java;

public class Popcorn {

    public void tasty(){
        System.out.println("salty");
    }

    public void m1(){
        System.out.println("Popcorn m1 method");
    }

}

class Test{

    public static void main(String args[]){

        Popcorn popcorn = new Popcorn(){
            public void tasty(){
                System.out.println("sweet");
            }
        };
        popcorn.tasty();

        Popcorn popcorn1 = new Popcorn();
        popcorn1.tasty();
        popcorn1.m1();
    }
}