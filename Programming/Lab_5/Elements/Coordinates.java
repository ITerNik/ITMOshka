package Elements;

public class Coordinates {
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
    public String toJson() {
        return String.format("{\n\t\t\"x\": %s,\n\t\t\"y\": %s\n\t}", x, y);
    }

    public Double getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
}
