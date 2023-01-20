package Things;

import Places.Place;

public class Fuel extends Resources{
    public Fuel(Amount amount) {
        this.amount = amount;
    }
    public Fuel() {
        this.amount = Amount.NONE;
    }

    @Override
    public String getTopic() {
        return "оставшемся топливе";
    }
    @Override
    public String toString() {
            return "топливо";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fuel f = (Fuel) o;
        return amount.equals(f.amount);
    }
    @Override
    public int hashCode() {
        return amount.getReal().hashCode();
    }
}
