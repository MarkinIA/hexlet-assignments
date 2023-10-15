package exercise;

import java.util.*;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> firstSet, Map<String, Object> secondSet) {
        Map<String, String> resMap = new LinkedHashMap<>();
        for (String map2 : secondSet.keySet()) {
            if (firstSet.containsKey(map2)) {
                if (firstSet.get(map2).equals(secondSet.get(map2))) {
                    resMap.put(map2, "unchanged");
                } else {
                    resMap.put(map2, "changed");
                }
            } else {
                resMap.put(map2, "added");
            }
        }

        for (String map1 : firstSet.keySet()) {
            if (!secondSet.containsKey(map1)) {
                resMap.put(map1, "deleted");
            }
        }
        
        return resMap;
    }
}
//END
