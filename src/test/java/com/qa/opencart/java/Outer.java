package com.qa.opencart.java;

public class Outer {

     int a = 10;

    public class Inner {
        int a = 100;

        public void m1(){
            int a = 1000;
            System.out.println("i am in inner class");
            System.out.println(a);
            System.out.println(this.a);
            System.out.println(Outer.this.a);

        }
    }

    /*public void m2(){

        Inner inner = new Inner();
        inner.m1();
    }*/

    public static void main(String args[]){

        new Outer().new Inner().m1();
        //new Outer().m2();
    }

}

