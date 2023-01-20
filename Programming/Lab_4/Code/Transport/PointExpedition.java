package Transport;

import Intentions.Solvable;
import Places.Place;
import Places.StopPoint;

import java.util.Arrays;

public class PointExpedition extends Expedition implements Solvable {
    private String name;
    private Place[] path;

    public PointExpedition(String name, Place end, Place... path) {
        this.name = name;
        this.endPoint = end;
        this.path = path;
    }

    public PointExpedition(String name) {
        this(name, new StopPoint(name));
    }
    public String start() {
        return this + " началась";
    }
    public void hasInPath(Place point) {
        if (!Arrays.asList(path).contains(point)) {
            System.out.printf("путь до %s не заворачивает на %s\n", endPoint, point);
        } else {
            System.out.printf("путь до %s проходит через %s\n", endPoint, point);
        }
    }

    @Override
    public String getTopic() {
        return name.substring(0, name.length() - 2) + "ой экспедиции";
    }

    @Override
    public String toString() {
        return name + "экспедиция";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointExpedition de = (PointExpedition) o;
        return (name.equals(de.name)) && (path == de.path) && (endPoint.equals(de.endPoint));
    }
    @Override
    public int hashCode() {
        int result = endPoint.hashCode();
        if(path != null) {
            for (Place point: path) {
                result = result * 29 + point.hashCode();
            }
        }
        result = 29 * result + name.hashCode();
        return result;
    }
}
