import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vietto on 20.10.16.
 */
public class MapTest {

    public static void main(String[] args) {

        Map<String, List<Car>> map = new HashMap<>();

        map.put("developers", new ArrayList<>());
        map.put("manager", new ArrayList<>());
        map.put("testers", new ArrayList<>());

        List<Car> cars = new ArrayList<>();
        for (Car car : cars) {
            map.get("developers").add(car);
        }

        for (Map.Entry<String, List<Car>> entry : map.entrySet()) {
            entry.getKey();
            entry.getValue();
        }

        for (String s : map.keySet()) {

        }

        for (List<Car> list : map.values()) {

        }


    }

}
