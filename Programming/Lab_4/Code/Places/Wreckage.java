package Places;

import Abstraction.Thickness;
import Transport.Plane;

public class Wreckage extends Place {
    private Plane broken;
    private Thickness cover;
    public Wreckage(Plane plane, Thickness cover) {
        broken = plane;
        this.cover = cover;
    }
    @Override
    public String toString() {
        return "место поломки " + broken;
    }
}
