package Pokemons;
import Moves.*;

public class Victreebel extends Weepinbell{
    public Victreebel() {
        super();
        setStats(80, 105, 65, 100, 70, 70);
        addMove(new Swagger());
    }
    public Victreebel(String name, int level) {
        super(name, level);
        setStats(80, 105, 65, 100, 70, 70);
        addMove(new Swagger());
    }
}
