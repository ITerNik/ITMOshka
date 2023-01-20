package Transport;

import Places.Place;

public class Route extends Expedition{
    Route(Place startPoint, Place endpoint, int distance){
        this.startPoint = startPoint;
        this.endPoint = endpoint;
        this.distance = distance;
    }
    private Place startPoint;
    private double distance;
    public Place[] getRoute() {
        Place[] res = {startPoint, endPoint};
        return res;
    }
    public String start() {
        return this + " начался";
    }
    public void getDistance() {
        System.out.printf("Расстояние от места %s до места %s - %d");
    }

    @Override
    public String toString() {
        return String.format("Путь от %s до %s", startPoint, endPoint);
    }
}
