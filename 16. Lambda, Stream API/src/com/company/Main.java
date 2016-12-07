package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    static String b = "b";

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("c");
        list.add("a");
        list.add("d");
        list.add("b");


        String a = "b";
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(a);
            }
        });

        list.sort((String o1, String o2) -> { return o1.compareTo(o2);});

        list.sort((o1,o2) -> o1.compareTo(o2));

        list.sort(String::compareTo);

        list.sort(Main::someMethod);

        list.sort((o1,o2) -> {
            System.out.println(b);
            return 0;
        });


        for (String s : list) {
            System.out.println(s);
        }

        funcMethod("ABS", Object::toString);

    }

    public static int someMethod(String a, String b) {
        return 0;
    }

    public static Object funcMethod(Object a, Transformer function) {
        return function.m(a);
    }

    interface Transformer {

        Object m(Object m);

    }

}

