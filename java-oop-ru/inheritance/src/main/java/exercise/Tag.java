package exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {

    private String tag;
    private Map<String, String> values = new LinkedHashMap<>();

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setValues(Map<String, String> values) {
        this.values.putAll(values);
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

    //everything is fucking fine
}
// END
