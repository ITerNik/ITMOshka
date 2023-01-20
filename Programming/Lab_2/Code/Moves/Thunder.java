package Moves;

import ru.ifmo.se.pokemon.*;

public class Thunder extends SpecialMove {
    public Thunder() {
        super(Type.ELECTRIC, 110.0, 0.7);
    }

    @Override
    protected void applyOppEffects(Pokemon def) {
        if (Math.random() < 0.3) {
            Effect.paralyze(def);
        }
    }

    @Override
    protected String describe() {
        return "атакует цель мощнейшим ударом молнии";
    }
}