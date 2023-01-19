package Transport;

import Abstraction.*;
import People.Leader;
import Places.Place;

public class DiscoveryPlane extends Plane {
    private Discovery mission;
    public DiscoveryPlane(Leader owner, Discovery mission) {
        this.owner = owner;
        this.mission = mission;
        this.location = mission.getStartPoint();
    }
    @Override
    public void move(Place to) {
        System.out.printf("%s должен отправиться в исследование от %s до %s\n", this, mission.getStartPoint(), mission.getEndPoint());
    }
    public void becomeFrequent() {
        System.out.println(this + " стал разведывать более часто");
    }
    @Override
    public String toString() {
        return "Экспедиционный самолет руководителя " + owner;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscoveryPlane dp = (DiscoveryPlane) o;
        return (mission.equals(dp.mission)) && (owner.equals(dp.owner));
    }
    @Override
    public int hashCode() {
        int result = mission.hashCode();
        result = 29 * result + owner.hashCode();
        return result;
    }
}
