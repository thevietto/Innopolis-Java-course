import java.util.*;
import java.util.stream.Collectors;

public class HelloWorld<T> {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");

//        List<Integer> integers = transformList(strings, arg -> Integer.parseInt(arg) * 10);
//
//        for (Integer integer : integers) {
//            System.out.println(integer);
//        }


//        List<Integer> collect = strings.stream()
//                .map(Integer::parseInt)
//                .map(i -> i * 5)
//                .peek(System.out::println)
//                .collect(Collectors.toList());
//
//        strings.stream().anyMatch(s -> s.equals("2"));
//
//        String s = strings.stream().max((o1, o2) -> o1.charAt(1) - o2.charAt(1)).get();

        List<String> collect1 = strings.stream().filter(st -> Integer.parseInt(st) > 1).collect(Collectors.toList());
        collect1.forEach(System.out::println);

//        JAVA STREAM API!!!

    }


    public static <IN, OUT> List<OUT> transformList(List<IN> inList, Transformer<IN, OUT> transformer) {
        List<OUT> result = new ArrayList<OUT>();
        for (IN in : inList) {
            result.add(transformer.transform(in));
        }
        return result;
    }


}


interface Transformer<IN, OUT> {

    OUT transform(IN arg);

}


