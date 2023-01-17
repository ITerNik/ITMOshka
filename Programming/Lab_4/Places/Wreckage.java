package Places;

import Abstraction.Thickness;
import Transport.Plane;

public class Wreckage extends Place {
    private Plane broken;
    private Thickness cover;
    Wreckage(Plane plane, Thickness cover) {
        broken = plane;
        this.cover = cover;
    }
    public void checkCover() {
        System.out.println("Ледяной покров " + cover.getName());
    }
    public void danger() {
        System.out.println("Местность " + this + " опасна, ожидаются: ветра и метели");
    }
    @Override
    public String toString() {
        return "место поломки" + broken;
    }
}
