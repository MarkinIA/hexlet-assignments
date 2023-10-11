package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> resList = new ArrayList<>();
        for (Map<String, String> book : books) {
            boolean rightRecord = true;
            for (String val : book.keySet()) {
                for (Map.Entry<String, String> map : where.entrySet()) {
                    if (val.equals(map.getKey()) && !book.get(val).equals(map.getValue())) {
                        rightRecord = false;
                        break;
                    }
                }
            }
            if (rightRecord) {
                resList.add(book);
            }
        }
        return resList;
    }
}
//END
