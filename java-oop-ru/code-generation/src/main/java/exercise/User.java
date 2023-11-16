package exercise;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

// BEGIN
@Data
@Builder
// END
class User {
    int id;
    String firstName;
    String lastName;
    int age;
}
