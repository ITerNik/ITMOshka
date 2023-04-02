package elements;

public class Coordinates implements Comparable<Coordinates> {
    private Double x; //Поле не может быть null
    private Integer y; //Значение поля должно быть больше -663, Поле не может быть null
    public Coordinates(double x, int y) {
        this.x = x;
        this.y = y;
    }
    public Coordinates() {};
    @Override
    public String toString() {
        return String.format("(%s, %s)",x, y);
    }

    public Double getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public int compareTo(Coordinates o) {
        double distanceThis = Math.sqrt(x * x + y * y);
        double distanceO = Math.sqrt(o.x * o.x + o.y * o.y);
        return Double.compare(distanceThis, distanceO);
    }
}
