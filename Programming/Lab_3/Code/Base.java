public class Base extends Place implements Delayable, Solvable{
    private Leader leader;
    private Resources[] reserves;
    Base(String name, Leader leader, Fuel fuel, Tents tents){
        this.name = name;
        this.leader = leader;
        Resources[] resources = {fuel, tents};
        this.reserves = resources;
    }
    Base(String name, Leader leader, Fuel fuel) {
        this(name, leader, fuel, new Tents(-1));
    }
    Base(String name, Leader leader, Tents tents) {
        this(name, leader, new Fuel(-1), tents);
    }
    Base(Leader leader, Fuel fuel, Tents tents){
       this(null, leader, fuel, tents);
    }
    Base(Leader leader, Fuel fuel){
        this(leader, fuel, new Tents(-1));
    }
    Base (String name) {
        this(name, new Leader("Неизвестный"), new Fuel(-1));
    }
    Base(Leader leader, Tents tents){
        this( leader, new Fuel(-1), tents);
    }
    public void getState(Resources res) {
        System.out.printf("На %s %s\n", this.toString(), res instanceof Tents? reserves[1].toString(): reserves[0].toString());
        delay();
    }
    public void prepareClose(Leader... people) {
        String res = "";
        for (Leader lead : people) {
            res += lead.toString();
            if (!lead.equals(people[people.length - 1])) {
                res += ", ";
            }
        }
        System.out.println(res + (people.length > 1? " подготавливают ": " подготавливает ") + this.toString()+ " к закрытию на более или менее длительный срок");
        delay();
    }
    public void moveReserves(Base to) {
        to.fillReserves(reserves);
        this.reserves[0] = new Fuel(0);
        this.reserves[1] = new Tents(0);
    }
    private void fillReserves(Resources[] reserves) {
        this.reserves[0].fill(reserves[0].getAmount());
        this.reserves[1].fill(reserves[1].getAmount());
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
