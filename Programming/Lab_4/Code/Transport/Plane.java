package Transport;

import People.Leader;
import Places.Place;

public abstract class Plane extends Transport implements Transferable{
    protected Leader owner;
    protected Place location;
    public void repair() {
        System.out.println("Идет ремонт " + this);
    }
}
