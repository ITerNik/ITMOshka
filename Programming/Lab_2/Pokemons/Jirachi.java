package Pokemons;

import Moves.*;
import ru.ifmo.se.pokemon.*;

public class Jirachi extends Pokemon {
    public Jirachi() {
        setStats(100, 100, 100, 100, 100, 100);
        setType(Type.STEEL, Type.PSYCHIC);
        setMove(new Thunder(), new CalmMind(), new DoubleTeam(), new ChargeBeam());
    }

    public Jirachi(String name, int level) {
        super(name, level);
        setStats(100, 100, 100, 100, 100, 100);
        setType(Type.STEEL, Type.PSYCHIC);
        setMove(new Thunder(), new CalmMind(), new DoubleTeam(), new ChargeBeam());
    }
}