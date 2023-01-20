package Transport;

import Places.Place;

public class Discovery extends Expedition{
    private Place startPoint;
    public Discovery(Place start, Place end) {
        startPoint = start;
        endPoint = end;
    }
    public  String start() {
        return this + "началось";
    }
    public Place getStartPoint() {
       return startPoint;
    }
    public Place getEndPoint() {
        return endPoint;
    }
    @Override
    public String toString() {
        return String.format("Исследование от %s до %s", startPoint, endPoint);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discovery d = (Discovery) o;
        return (startPoint.equals(d.startPoint)) && (endPoint.equals(d.endPoint));
    }
    @Override
    public int hashCode() {
        int result = startPoint.hashCode();
        result = 29 * result + endPoint.hashCode();
        return result;
    }
}
