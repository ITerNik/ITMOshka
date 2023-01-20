public class DiscoveryPlane extends Plane implements Delayable{
    private Discovery mission;
    DiscoveryPlane(Leader owner, Discovery mission) {
        this.owner = owner;
        this.mission = mission;
        this.location = mission.getStartPoint();
    }
    @Override
    public void move(Place to) {
        System.out.printf("%s должен отправиться в исследование от %s до %s\n", this, mission.getStartPoint(), mission.getEndPoint());
        delay();
    }
    @Override
    public String toString() {
        return "Экспедиционный самолет " + owner + "a";
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
