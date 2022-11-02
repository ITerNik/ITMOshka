package Pokemons;

import Moves.*;

public class Rapidash extends Ponyta{
    public Rapidash() {
        super();
        setStats(65, 100, 70, 80, 80, 105);
        addMove(new PoisonJab());
    }
    public Rapidash(String name, int level) {
        super(name, level);
        setStats(65, 100, 70, 80, 80, 105);
        addMove(new PoisonJab());
    }
}
