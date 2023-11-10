package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage{

    Map<String, String> data = new HashMap<>();

    public InMemoryKV(Map<String, String> data) {
        this.data.putAll(data);
    }
    @Override
    public void set(String key, String value) {
        data.put(key, value);
    }

    @Override
    public void unset(String key) {
        data.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        if (!data.isEmpty()) {
            return data.get(key) == null ? defaultValue : data.get(key);
        }
        return defaultValue;
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(data);
    }
}
// END
