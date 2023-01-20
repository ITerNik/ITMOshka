public class Crew implements Transferable, Delayable{
    private Leader[] leaders;
    private int size;
    private Place location;
    Crew(int size, Place location, Leader... leaders) {
        this.leaders = leaders;
        this.size = size;
        this.location = location;
    }
    public String getMembers() {
        String res = "";
        for (Leader lead: leaders) {
            res += lead.toString();
            if (!lead.equals(leaders[leaders.length - 1])) {
                res += ", ";
            }
        }
        return String.format("%s и %d членов экспедиции", res, size);
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
        return "Команда " + leaders[0] + "а";
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crew cr = (Crew) o;
        return (leaders == cr.leaders) && (size == cr.size);
    }
    @Override
    public int hashCode() {
        int result = size;
        for (Leader lead: leaders) {
            result = 29 * result + lead.hashCode();
        }
        return result;
    }
}
