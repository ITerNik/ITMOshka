package Transport;

import Abstraction.Time.Time;

import java.lang.reflect.Field;

public class DirectExpedition extends Expedition{
    private Direction direction;
    public DirectExpedition(Direction direction) {
        this.direction = direction;
    }
    public String start(){
        return this + " началась";
    }
    public void delay() {
        System.out.println(this + "откладывается");
    }
    public void delay(Time time) {
        System.out.println(this + " откладывается не менее чем на " + time.getTime());
    }

    @Override
    public String toString() {
        return "Экспедиция в направлении " + direction.getName();
    }
}
