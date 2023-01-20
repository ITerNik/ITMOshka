package Places.Nature;

import People.Leader;
import Places.Place;

public abstract class Landscape extends Place {
    public Landscape(String name) {
        this.name = name;
    }
    public Landscape() {}
    public abstract void surround(Leader lead);

}
