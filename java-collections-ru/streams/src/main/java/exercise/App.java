package exercise;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        return emails.stream()
                .filter(addr -> addr.contains("@yandex.")
                || addr.contains("@gmail.")
                || addr.contains("@hotmail."))
                .count();
    }
}

// END
