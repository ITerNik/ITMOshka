package Moves;

import ru.ifmo.se.pokemon.*;

public class PoisonJab extends PhysicalMove {
    public PoisonJab() {
        super (Type.POISON, 80.0, 1.0);
    }
    @Override
    protected void applyOppEffects(Pokemon def) {
        if (Math.random() < 0.3) {
            Effect.poison(def);
        }
    }
    @Override
    protected String describe () {
        return "атакует цель ядовитым кулаком";
    }
}
