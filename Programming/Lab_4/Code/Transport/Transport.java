package Transport;

import Places.Place;

public abstract class Transport implements Transferable{
    protected Place location;
    public void find() {
        System.out.println(this + "находится в месте: " + location);
    }
    public void move(Place to) {
        location = to;
    }
}
