public class Fuel extends Resources{
    Fuel(double percentage) {
        if (percentage > 100) {
            this.amount = 100;
        } else {
            this.amount = percentage;
        }
    }
    @Override
    public String getTopic() {
        return "оставшемся топливе";
    }
    @Override
    public String toString() {
        if (amount >= 0) {
            return "топлива " + convert();
        } else return convert() + "топлива";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fuel f = (Fuel) o;
        return Double.compare(amount, f.amount) == 0;
    }
    @Override
    public int hashCode() {
        return (int)(amount * 1e10);
    }
}
