package Places;

import Abstraction.Time.Uncountable;
import Intentions.*;
import People.*;
import Abstraction.*;
import Things.*;

public class Base extends Place implements Solvable {
    private Leader leader;
    private Resources[] reserves;
    public Base(String name, Leader leader, Fuel fuel, Tents tents){
        this.name = name;
        this.leader = leader;
        Resources[] resources = {fuel, tents};
        this.reserves = resources;
    }
    Base(String name, Leader leader, Fuel fuel) {
        this(name, leader, fuel, new Tents());
    }
    Base(String name, Leader leader, Tents tents) {
        this(name, leader, new Fuel(), tents);
    }
    public Base(Leader leader, Fuel fuel, Tents tents){
       this(null, leader, fuel, tents);
    }
    public Base(Leader leader, Fuel fuel){
        this(leader, fuel, new Tents());
    }
    public Base(String name) {
        this(name, new Leader("Неизвестный"), new Fuel());
    }
    Base(Leader leader, Tents tents){
        this( leader, new Fuel(), tents);
    }
    public void getState(Class res) {
        System.out.printf("На %s %s\n", this.toString(), res == Tents.class? reserves[1].getState(): reserves[0].getState());
    }
    public void startWorks() {
        System.out.printf("%s начал буровые работы на своей базе\n", leader);
    }
    public void startWorks(Intentive intention) {
        System.out.printf("%s %s начать буровые работы на своей базе\n", leader, intention.voiceIntention(Gender.MALE));
    }
    public void prepareClose(Group people) {
        System.out.println(people + " подготавливают место:" + this.toString() + " к закрытию на более или менее длительный срок");
    }
    public void moveReserves(Base to) {
        this.reserves[0] = new Fuel();
        this.reserves[1] = new Tents();
    }
    public Resources[] getReserves() {
        return reserves;
    }
    public Tents getTents() {
        return (Tents)reserves[1];
    }
    @Override
    public String getTopic() {
        return "ресурсах на " + this;
    }
    @Override
    public String toString() {
        return "база " + (name == null? leader.toString() + "а": "\"" + name + "\"");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Base base = (Base) o;
        return (name.equals(base.name)) && (leader.equals(base.leader));
    }
    @Override
    public int hashCode() {
        int result = name == null ? 0 : name.hashCode();
        result = 29 * result + leader.hashCode();
        return result;
    }
}
