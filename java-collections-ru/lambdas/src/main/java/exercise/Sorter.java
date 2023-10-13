package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
public class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> people) {
        Comparator<Map<String, String>> reverseTimeComparator =
                Comparator.comparing(h -> h.get("birthday"));
        System.out.println(people);
        return people.stream()
                .filter(man -> man.get("gender").equals("male"))
                .sorted(reverseTimeComparator)
                .map(m -> m.get("name"))
                .collect(Collectors.toList());
    }
}
// END
