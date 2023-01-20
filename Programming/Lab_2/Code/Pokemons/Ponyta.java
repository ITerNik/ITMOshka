package Pokemons;

import ru.ifmo.se.pokemon.*;
import Moves.*;

public class Ponyta extends Pokemon {
    public Ponyta() {
        setStats(50, 85, 55, 65, 65, 90);
        setType(Type.FIRE);
        setMove(new WillOWisp(), new Growl(), new Stomp());
    }

    public Ponyta(String name, int level) {
        super(name, level);
        setStats(50, 85, 55, 65, 65, 90);
        setType(Type.FIRE);
        setMove(new WillOWisp(), new Growl(), new Stomp());
    }
}