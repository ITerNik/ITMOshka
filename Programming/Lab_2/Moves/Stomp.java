package Moves;

import ru.ifmo.se.pokemon.*;

public class Stomp extends PhysicalMove {
    public Stomp() {
        super (Type.NORMAL, 65.0, 1.0);
    }
    @Override
    protected void applyOppEffects(Pokemon def) {
        if (Math.random() < 0.3) {
            Effect.flinch(def);
        }
    }
    @Override
    protected String describe () {
        return "топчет цель";
    }
}
