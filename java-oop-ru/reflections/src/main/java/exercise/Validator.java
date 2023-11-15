package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) throws IllegalAccessException {
        List<String> result = new ArrayList<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            NotNull notNull = field.getDeclaredAnnotation(NotNull.class);
            if (notNull != null) {
                field.setAccessible(true);
                Object obj = field.get(address);
                if (obj == null) {
                    result.add(field.getName());
                }
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) throws IllegalAccessException {
        Map<String, List<String>> resMap = new HashMap<>();
        for(Field field : address.getClass().getDeclaredFields()) {
            String errorMsg = "";
            NotNull notNull = field.getDeclaredAnnotation(NotNull.class);
            MinLength minLength = field.getDeclaredAnnotation(MinLength.class);
            if (notNull != null || minLength != null) {
                field.setAccessible(true);
                Object obj = field.get(address);
                if (obj == null) {
                    errorMsg = "can not be null";
                    resMap.put(field.getName(), List.of(errorMsg));
                } else if (minLength != null && obj.toString().length() < minLength.minLength()) {
                    errorMsg = "length less than 4";
                    resMap.put(field.getName(), List.of(errorMsg));
                }
            }
        }
        return resMap;
    }
}
// END
