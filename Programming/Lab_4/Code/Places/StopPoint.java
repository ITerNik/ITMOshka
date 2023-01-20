package Places;

import Intentions.Solvable;
import People.Group;
import People.Leader;

public class StopPoint extends Place implements Solvable {
    public StopPoint(String name) {
        this.name = name;
    }
    public void stay(Group people) {
        System.out.println(people + " остались зимовать в " + this.toString());
    }
    @Override
    public String getTopic() {
        return "зимовки в " + this.toString().substring(0, this.toString().length() - 1) + "е";
    }
    @Override
    public String toString() {
        return name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StopPoint sp = (StopPoint) o;
        return name.equals(sp.name);
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
