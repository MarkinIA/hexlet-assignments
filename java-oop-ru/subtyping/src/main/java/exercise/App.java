package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage){
        Map<String, String> middleMap = new HashMap<>(storage.toMap());
        for (Map.Entry<String, String> entry : middleMap.entrySet()) {
            String prevVal = entry.getValue();
            String prevKey = entry.getKey();
            storage.unset(prevKey);
            storage.set(prevVal, prevKey);
        }
    }

}
// END
