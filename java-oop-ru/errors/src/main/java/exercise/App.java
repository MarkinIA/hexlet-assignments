package exercise;

import exercise.exception.CustomException;

// BEGIN
public class App {
    public static void printSquare(Circle circle) throws Exception {
        try {
            int sqr = (int) Math.round(circle.getSquare());
            System.out.println(sqr);
        } catch (Exception e) {
            System.out.println("Не удалось посчитать площадь");
        }
        System.out.println("Вычисление окончено");
    }
}
// END
