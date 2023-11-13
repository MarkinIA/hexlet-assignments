package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag{

    private String body;
    private List<Tag> simpleTags = new ArrayList<>();
    public PairedTag(String tag, Map<String, String> values, String body, List<Tag> simpleTags) {
        super(tag, values);
        this.body = body;
        this.simpleTags.addAll(simpleTags);
    }

    @Override
    public String toString() {
        String tagStr = "";
        for (Tag tag : simpleTags) {
            tagStr += tag.toString();
        }
        return "<" + getTag() + getValues() + ">" + body + tagStr + "</" + getTag() + ">";
    }

}
// END
