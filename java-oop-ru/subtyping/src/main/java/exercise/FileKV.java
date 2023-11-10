package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {

    private final Map<String, String> data = new HashMap<>();
    private final String path;

    public FileKV(String path, Map<String, String> data) {
        this.data.putAll(data);
        this.path = path;
        writeToFile(this.path, this.data);
    }

    public void writeToFile(String path, Map<String, String> data) {
        String json = Utils.serialize(data);
        Utils.writeFile(path, json);
    }

    public Map<String, String> readFromFile() {
        String json = Utils.readFile(path);
        return Utils.unserialize(json);
    }

    @Override
    public void set(String key, String value) {
        data.put(key, value);
        Utils.writeFile(path, Utils.serialize(data));
    }

    @Override
    public void unset(String key) {
        data.remove(key);
        Utils.writeFile(path, Utils.serialize(data));
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
