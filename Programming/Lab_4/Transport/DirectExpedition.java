package Transport;

import Abstraction.*;

public class DirectExpedition {
    private Direction direction;
    DirectExpedition(Direction direction) {
        this.direction = direction;
    }
    public void postpone() {
        System.out.println(this + "откладывается");
    }
    public void postpone(Time time) {
        System.out.println(this + "откладывается" + time.getTime());
    }

    @Override
    public String toString() {
        return "Экспедиция в направлении" + direction.getName();
    }
}
