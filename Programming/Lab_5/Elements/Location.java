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
        return String.format("(%d, %d, %d)", x, y, z);
    }
    public String toJson() {
        return String.format("{\n\"x\": %d,\n\"y\": %d,\n\"z\": %d\n}", x, y, z);
    }
}
