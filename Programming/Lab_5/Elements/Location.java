package Elements;

public class Location {
    private long x;
    private Double y; //Поле не может быть null
    private float z;
    public Location(long x, double y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s)", x, y, z);
    }
    public String toJson() {
        return String.format("{\n\"x\": %s,\n\"y\": %s,\n\"z\": %s\n}", x, y, z);
    }
}
