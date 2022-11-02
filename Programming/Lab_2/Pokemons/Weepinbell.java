package Pokemons;
import Moves.*;

public class Weepinbell extends Bellsprout{
    public Weepinbell() {
        super();
        setStats(60, 90, 50, 85, 45, 55);
        addMove(new Acid());
    }
    public Weepinbell(String name, int level) {
        super(name, level);
        setStats(60, 90, 50, 85, 45, 55);
        addMove(new Acid());
    }
}
