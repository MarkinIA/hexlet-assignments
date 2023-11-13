package exercise;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {

    private String tag;
    private Map<String, String> values = new LinkedHashMap<>();

    public Tag(String tag, Map<String, String> values) {
        this.tag = tag;
        this.values = values;
    }
    public String getTag() {
        return tag;
    }

    public String getValues() {
        if (!values.isEmpty()) {
            return values.entrySet().stream()
                    .map(entry -> " " + entry.getKey() + "=" + "\"" + entry.getValue() + "\"")
                    .collect(Collectors.joining());
        }
        return "";
    }
}
// END
