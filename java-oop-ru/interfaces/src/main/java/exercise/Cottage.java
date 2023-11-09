package exercise;

// BEGIN
public class Cottage implements Home, Comparable <Home>{
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public int getFloorCount() {
        return floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        return Double.compare(this.getArea(), another.getArea());
    }

    @Override
    public String toString() {
        return this.getFloorCount() + " этажный коттедж площадью " + this.getArea() + " метров";
    }
}
// END
