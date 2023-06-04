package com.qa.opencart.java;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Mycomparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        String s1 = (String) o1;
        String s2 = (String) o2;
        return s1.compareTo(s2);
    }

    @Override
    public Comparator reversed() {
        return Comparator.super.reversed();
    }
}

public class FactorsTest {

    public void dublicatesNums() {
        int[] values = {2, 5, 4, 7, 8, 4, 5, 1, 2, 6, 4};

        Map<Integer, Integer> map = new HashMap();

        for (int b : values) {
            if (!map.containsKey(b)) {
                map.put(b, 1);
            } else
                map.put(b, map.get(b) + 1);
        }

        for (Integer i : map.keySet()) {
            if (map.get(i) > 1) {
                System.out.println("dublicate elements are " + i + " and count " + map.get(i));
            }
        }
    }

    public static void dublicatesWords() {
        String s = "hi this is naveen reddy is and hi ready to move is hi";
        String values[] = s.split(" ");

        Map<String, Integer> map = new HashMap();

        for (String b : values) {
            if (!map.containsKey(b)) {
                map.put(b, 1);
            } else
                map.put(b, map.get(b) + 1);
        }

        for (String i : map.keySet()) {
            if (map.get(i) > 1) {
                System.out.println("duplicate strings are " + i + " and count " + map.get(i));
            }
        }
    }
    public static void wordsDublicate(){
        String[] values = {"naveen","sai","krish","vishwa","arjun","sai","kumari","vishwa","sai"};

        Map<String, Integer> map = new HashMap();

        for (String b : values) {
            if (!map.containsKey(b)) {
                map.put(b,1);
            } else
                map.put(b, map.get(b) + 1);
        }

        for (String i : map.keySet()) {
            if (map.get(i) >1) {
                System.out.println("dublicate elements are " + i + " and count " + map.get(i));
            }
        }
    }

    public static void main(String[] args) {

        /*String st = "hi my name is naveen, reddy; from dilwarpur, 988987 nkfdjnb bsfdkbsfd";
        st = st.replaceAll("\\W","");
        System.out.println(st);
        System.out.println(st.length());*/

        dublicatesWords();
        wordsDublicate();

        //prime(67);
         printPrimeNums(100);
        //sumOfDigits(3654);
        //reverseNum(252);
        //factorial(3);
        //amicable(220,284);
    }

    public static void amicable(int num1, int num2) {

        int n1 = num1;
        int n2 = num2;
        int s1 = 0;
        int s2 = 0;

        for (int i = 1; i <= n1 / 2; i++) {
            if (n1 % i == 0) {
                s1 = s1 + i;
            }
        }
        for (int i = 1; i <= n2 / 2; i++) {
            if (n2 % i == 0) {
                s2 = s2 + i;
            }
        }
        if (n2 == s1 && n1 == s2) {
            System.out.println("Given numbers are amicable");
        } else
            System.out.println("Given numbers are not amicable");
    }

    public static void factorial(int number) {
        int f = 1;
        for (int i = 1; i <= number; i++) {
            f = f * i;
        }
        System.out.println("Factorial of the given number is " + f);
    }

    public static void reverseNum(int number) {
        int temp = number;
        int rem = 0;
        int sum = 0;
        while (number != 0) {
            rem = number % 10;
            sum = sum * 10 + rem;
            number = number / 10;
        }
        System.out.println("reverse number is " + sum);
        if (temp == sum) {
            System.out.println("Given number is a palindrome");
        }
    }

    public static void sumOfDigits(int number) {
        int rem = 0;
        int sum = 0;
        while (number != 0) {
            rem = number % 10;
            sum = sum + rem;
            number = number / 10;
        }
        System.out.println("sum of the digits of the given number is " + sum);
    }

    public static void printPrimeNums(int n) {

        for (int i = 2; i <= n; i++) {
            int count = 0;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0)
                System.out.print(i+" ");
        }
    }

    public static void prime(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        if (count == 2)
            System.out.println(+number + " is a prime number");
        else
            System.out.println(+number + " is not a prime number");
    }
}
