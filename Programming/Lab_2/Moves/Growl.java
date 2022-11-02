package Moves;

import ru.ifmo.se.pokemon.*;

public class Growl extends StatusMove {
    public Growl() {
        super(Type.NORMAL, 0.0, 1.0);
    }
    @Override
    protected void applyOppEffects(Pokemon def) {
        def.setMod(Stat.ATTACK, -1);
    }
    @Override
    protected String describe() {
        return "устрашающе рычит";
    }
}
