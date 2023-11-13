package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String tag, Map<String, String> values) {
        super(tag, values);
    }

    @Override
    public String toString() {
        return "<" + getTag() + getValues() + ">";
    }
}
// END
