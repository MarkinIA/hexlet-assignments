package exercise;

// BEGIN
public class Circle {

    private Point points;
    private final int radius;
    public Circle(Point points, int radius) {
        this.points = points;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw NegativeRadiusException.RADIUS_IS_INCORRECT;
        }
        return Math.PI * radius * radius;
    }
}
// END
