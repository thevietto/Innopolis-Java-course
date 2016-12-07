package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vietto on 05.12.16.
 */
public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("c");
        list.add("a");
        list.add("d");
        list.add("b");

        list.forEach(System.out::println);

    }

}


interface A {

    default void method1() {

    }
}

interface B {

    default void method1() {

    }
}

class C implements A, B {

    @Override
    public void method1() {

    }
}