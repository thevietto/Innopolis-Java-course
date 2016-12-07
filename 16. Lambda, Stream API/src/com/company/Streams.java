package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by vietto on 05.12.16.
 */
public class Streams {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

//        list.stream().filter(i -> i > 2).map(i -> i + 1).map(String::valueOf).forEach(System.out::println);

//        List<Integer> collect = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
//        collect.forEach(System.out::println);

//        list.stream().distinct() уникальность

//        list.stream().sorted().limit(3).skip(5);

//        list.stream()
//                .filter(i -> i > 3)
//                .peek(System.out::println)
//                .filter(i -> i > 2)
//                .map(i -> i - 2)
//                .filter(i -> i > 2)
//                .forEach(System.out::println);

//        boolean b = list.stream().anyMatch(i -> i > 4);
//        boolean c = list.stream().allMatch(i -> i > 4);
//
//        long count = list.stream().count();
//
//
//        Optional<Integer> first = list.stream().parallel().filter(i -> i > 1).findFirst();
//        Optional<Integer> any = list.stream().filter(o -> o > 1).findAny();
//
//        Stream.of("f", "i", "o").filter(Objects::nonNull).collect(Collectors.joining(" "));
//
//        Stream<Integer> stream = list.stream().parallel();
//        Stream<Integer> stream2 = list.stream().sequential();
//
//        List<Person> persons = new ArrayList<>();
//        persons.stream().flatMap(p -> p.getFriends().stream());
//
//
//        new Random().ints(1, 20).limit(10).forEach(i -> System.out.println(i));
//
//        long l = System.nanoTime();
//        IntStream.range(1, 100_000_000).toArray();
//        long l2 = System.nanoTime();
//        System.out.println(l2 - l);


        List<String> list2 = new ArrayList<>();
        list2.add("A");
        list2.add("B");

        list2.removeIf(s -> s.length() < 10);
//        VS
        Set<String> toRemove = new HashSet<>();
        for (String s : list2) {
            if (s.length() < 10) {
                toRemove.add(s);
            }
        }
        list2.removeAll(toRemove);

    }
}

class Person {

    List<Person> friends;

    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }
}
