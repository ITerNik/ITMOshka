package elements;

import annotations.Builder;
import exceptions.BadParametersException;

public class Location implements Comparable<Location> {
    private long x;
    private Double y; //Поле не может быть null
    private float z;

    public Location() {
    }

    public Location(long x, double y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Builder(field = "Координата X локации", order = 1)
    public void setX(String x) {
        try {
            this.x = x.isBlank() ? 0 : Long.parseLong(x);
        } catch (NumberFormatException e) {
            throw new BadParametersException("Координата X должна быть целым числом");
        }
    }

    @Builder(field = "Координата Y локации", order = 2)
    public void setY(String y) {
        try {
            if (y.isBlank()) throw new BadParametersException("Координата Y должна быть определена");
            this.y = Double.parseDouble(y);
        } catch (NumberFormatException e) {
            throw new BadParametersException("Координата Y должна быть вещественным числом");
        }
    }

    @Builder(field = "Координата Z локации", order = 3)
    public void setZ(String z) {
        try {
            this.z = z.isBlank() ? 0 : Float.parseFloat(z);
        } catch (NumberFormatException e) {
            throw new BadParametersException("Координата Z должна быть вещественным числом");
        }
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s)", x, y, z);
    }

    @Override
    public int compareTo(Location o) {
        double distanceThis = Math.sqrt(x * x + y * y + z * z);
        double distanceO = Math.sqrt(o.x * o.x + o.y * o.y + o.z * o.z);
        return Double.compare(distanceThis, distanceO);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != Location.class) return false;
        Location location = (Location) o;
        return compareTo(location) == 0;
    }
}
