package Pokemons;

import ru.ifmo.se.pokemon.*;
import Moves.*;

public class Bellsprout extends Pokemon{
    public Bellsprout() {
        setStats(50, 75, 35, 70, 30, 40);
        setType(Type.GRASS, Type.POISON);
        setMove(new Confide(), new Rest());
    }
    public Bellsprout(String name, int level) {
        super(name, level);
        setStats(50, 75, 35, 70, 30, 40);
        setType(Type.GRASS, Type.POISON);
        setMove(new Confide(), new Rest());
    }
}
