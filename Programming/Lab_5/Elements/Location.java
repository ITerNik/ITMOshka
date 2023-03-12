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
    public Location() {};

    @Override
    public String toString() {
        return String.format("(%s, %s, %s)", x, y, z);
    }
    public String toJson() {
        return String.format("{\n\t\t\"x\": %s,\n\t\t\"y\": %s,\n\t\t\"z\": %s\n\t}", x, y, z);
    }

    public Double getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public long getX() {
        return x;
    }
}
