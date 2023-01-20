package Moves;

import ru.ifmo.se.pokemon.*;

public class Acid extends SpecialMove {
    public Acid() {
        super(Type.POISON, 40.0, 1.0);
    }
    @Override
    protected void applyOppEffects(Pokemon def) {
        if (Math.random() < 0.1) {
            def.setMod(Stat.SPECIAL_DEFENSE,-1);
        }
    }
    @Override
    protected String describe() {
        return "атакует противника струями едкой кислоты";
    }
}
