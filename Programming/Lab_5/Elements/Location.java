package elements;

public class Location implements Comparable<Location> {
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

    public Double getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public long getX() {
        return x;
    }

    @Override
    public int compareTo(Location o) {
        double distanceThis = Math.sqrt(x * x + y * y + z * z);
        double distanceO = Math.sqrt(o.x * o.x + o.y * o.y + o.z * o.z);
        return Double.compare(distanceThis, distanceO);
    }
}
