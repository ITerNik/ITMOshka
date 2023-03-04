package Elements;

public class Coordinates {
    private Double x; //Поле не может быть null
    private Integer y; //Значение поля должно быть больше -663, Поле не может быть null
    public Coordinates(double x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)",x, y);
    }
    public String toJson() {
        return String.format("{\n\"x\": %d,\n\"y\": %d\n}", x, y);
    }
}
