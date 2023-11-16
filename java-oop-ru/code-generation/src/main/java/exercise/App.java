package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path path, Car car) throws IOException {
        String data = Car.serialize(car);
        Files.writeString(path, data);
    }

    public static Car extract(Path path) throws IOException {
        String data = Files.readString(path.toAbsolutePath().normalize());
        return Car.unserialize(data);
    }
}
// END
