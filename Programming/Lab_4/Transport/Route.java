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
    public void getDistance() {
        System.out.printf("Расстояние от места %s до места %s - %d");
    }
}
