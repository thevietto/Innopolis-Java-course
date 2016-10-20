import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class EqualsHashCode {

    public static void main(String[] args) {
        Set<Car> set = new HashSet<>();

        set.add(new Toyota("mark1"));
        set.add(new Toyota("mark1"));
        set.add(new Toyota("mark1"));

        set.add(new Toyota("mark2"));

        set.add(new Toyota("mark1"));
        set.add(new Toyota("mark1"));
        set.add(new Toyota("mark1"));

        System.out.println(set.size());
        System.out.println(set.contains(new Toyota("mark1")));


        Set<Car> set2 = new TreeSet<>((o1, o2) -> o1.getName().compareTo(o2.getName()));

        set2.add(new Toyota("mark2"));
        set2.add(new Toyota("mark1"));
        set2.add(new Toyota("mark3"));
        set2.add(new Toyota("mark1"));


        for (Car car : set2) {
            System.out.println(car);
        }


    }

}
