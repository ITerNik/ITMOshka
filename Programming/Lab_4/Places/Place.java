package Places;

import Abstraction.Thickness;

abstract public class Place {
    protected Thickness cover;
    protected String name;
    public void checkCover() {
        System.out.println("Ледяной покров " + cover.getName());
    }
    public void danger() {
        System.out.println("Местность " + this + " опасна, ожидаются: ветра и метели");
    }
}
