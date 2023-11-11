package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String tag, Map<String, String> values) {
        setTag(tag);
        setValues(values);
    }

    @Override
    public String toString() {
        return "<" + getTag() + getValues() + ">";
    }
}
// END
