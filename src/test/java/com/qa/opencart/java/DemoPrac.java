package com.qa.opencart.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface I1 {

    default void show() {
        System.out.println("hi iam from I1");
    }

}

interface I2 {

    default void show() {
        System.out.println("hi iam from I2");
    }

}

class Demo1 {

    public void show() {
        System.out.println("hi iam from demo1 class");
    }
}

public class DemoPrac extends Demo1 implements I2, I1 {


    public static void main(String args[]) {

        List<Integer> list = Arrays.asList(4, 1, 7, 2, 8, 3, 9, 5, 10, -1);
        System.out.println(list);

        System.out.println(list.stream().filter(n -> n % 2 == 0).count());


        System.out.println(list.stream().map(a -> a + 2).collect(Collectors.toList()));

        System.out.println(list.stream().sorted().collect(Collectors.toList()));//default natural sorting order
        System.out.println(list.stream().sorted((i1, i2) -> i1.compareTo(i2)).collect(Collectors.toList()));//ascending order
        System.out.println(list.stream().sorted((i1, i2) -> -i1.compareTo(i2)).collect(Collectors.toList()));//descending order


        System.out.println(list.stream().min((i1, i2) -> i1.compareTo(i2)).get());//min value
        System.out.println(list.stream().max((i1, i2) -> i1.compareTo(i2)).get());//max value

        list.stream().forEach(System.out::print);//print all values

        Integer[] array1 = list.stream().toArray(Integer[]::new);//convert list to array
        Stream.of(array1).forEach(System.out::print);//again print all values form the array











       /* Demo1 demo1 = new Demo1();
        demo1.show();*/
    }

    @Override
    public void show() {
        I2.super.show();
    }


}
