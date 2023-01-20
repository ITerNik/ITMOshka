package Things;

import Intentions.Solvable;
import Places.*;
import Transport.Transferable;

public abstract class Resources implements Solvable, Transferable {
    protected Amount amount;

    public enum Amount {
        LIMIT("Как можно больше"),
        MOST("Большая часть"),
        ENOUGH("Достаточно"),
        NONE("Нет");
        private String real;
        private int level;
        protected String getReal() {
            return real;
        }
        Amount(String real) {
            this.real = real;
        }
    }
    public String getState() {
        return this + " в количестве: " + amount.real;
    }
    public Amount getAmount() {
        return amount;
    }
    @Override
    public void move(Place to) {}
}
