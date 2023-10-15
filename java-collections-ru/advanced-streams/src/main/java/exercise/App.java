package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String getForwardedVariables(String data) {
        String[] modData = data.split("\n");
        String resData = Arrays.stream(modData)
                .filter(str -> str.startsWith("environment"))
                .collect(Collectors.joining(", "));
        modData = resData.split(",");
        String finalData = String.join(",", modData);
        modData = finalData.split("\"");
        finalData = String.join(",", modData);
        modData = finalData.split(",");
        resData = Arrays.stream(modData)
                .filter(str -> str.startsWith("X_FORWARDED_"))
                .map(m -> m.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));

        return resData;
    }
}
//END
