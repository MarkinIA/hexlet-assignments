package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> resultMap = new HashMap<>();
        if (sentence.isEmpty()) {
            return resultMap;
        } else {
            String[] words = sentence.split(" ");
            int amount = 1;
            for(String str: words) {
                if(resultMap.containsKey(str)) {
                    amount = resultMap.get(str);
                    resultMap.replace(str, amount + 1);
                } else {
                    resultMap.put(str, amount);
                }
            }
        }
        return resultMap;
    }

    public static String toString(Map<String, Integer> sentence) {
        if (sentence.isEmpty()) {
            return "{}";
        } else {
            String resString = "{\n";
            for (Map.Entry<String, Integer> str: sentence.entrySet()) {
                resString += "  " + str.getKey() + ": " + str.getValue() + "\n";
            }
            resString += "}";
            return resString;
        }
    }
}
//END
