package People;

import Abstraction.Delayable;
import Places.Place;
import Transport.Transferable;

public class Crew extends Group implements Transferable, Delayable {
    private int size;
    private Place location;
    public Crew(int size, Place location, Leader... members) {
        this.members = members;
        this.size = size;
        this.location = location;
    }
    public String getMembers() {
        return String.format("%s, а также %d членов экспедиции", new Group(members), size);
    }
    public void finish() {
        System.out.println(this + " решила докончить начатое");
        delay();
    }
    @Override
    public void move (Place to) {
        location = to;
    }
    @Override
    public String toString() {
        return "Команда руководителя: " + members[0];
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crew cr = (Crew) o;
        return (members == cr.members) && (size == cr.size);
    }
    @Override
    public int hashCode() {
        int result = size;
        for (Leader lead: members) {
            result = 29 * result + lead.hashCode();
        }
        return result;
    }
}
