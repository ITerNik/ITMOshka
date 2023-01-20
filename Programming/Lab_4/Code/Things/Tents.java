package Things;

public class Tents extends Resources {
    public Tents(Amount amount) {
        this.amount = amount;
    }
    public Tents() {
        this.amount = Amount.NONE;
    }
    public String getState() {
        return this + " в количестве: " + amount.getReal();
    }

    public void strengthen() {
        System.out.println("Несколько палаток уже укреплены кубами плотного снега");
    }
    @Override
    public String getTopic() {
        return "палаток";
    }
    @Override
    public String toString() {
        return "палатки";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tents t = (Tents) o;
        return amount.equals(t.amount);
    }
    @Override
    public int hashCode() {
        return amount.getReal().hashCode();
    }
}
