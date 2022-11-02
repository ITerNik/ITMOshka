package Moves;

import ru.ifmo.se.pokemon.*;

public class Rest extends StatusMove {
    public Rest() {
        super(Type.PSYCHIC, 0.0, 1.0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        Effect e = new Effect().condition(Status.SLEEP).attack(0.0).turns(2);
        p.setMod(Stat.HP, -(int)(p.getStat(Stat.HP) - p.getHP()));
        p.restore();
        p.setCondition(e);
    }

    @Override
    protected String describe() {
        return "решает поспать";
    }
}