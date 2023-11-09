package exercise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int amount) {
        List<String> resList = new ArrayList<>();
        if (!apartments.isEmpty()) {
            Collections.sort(apartments, (a1, a2) -> (int) (a1.getArea() - a2.getArea()));
            for (int i = 0; i < amount; i++) {
                resList.add(apartments.get(i).toString());
            }
        }
        return resList;
    }
}
// END
