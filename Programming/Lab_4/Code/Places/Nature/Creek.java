package Places.Nature;

import People.Leader;

public class Creek extends Landscape {
    public Creek(String name) {
        this.name = name;
    }
    public Creek() {
        super("Новый");
    }
    public void surround(Leader leader) {
        System.out.println(leader + " окружен красотой побережья залива " + (name == null? "": name));
    }

    @Override
    public String toString() {
        return "залив";
    }
}
