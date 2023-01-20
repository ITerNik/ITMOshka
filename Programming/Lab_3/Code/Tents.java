public class Tents extends Resources implements Delayable{
    Tents(double percentage) {
        if (percentage > 100) {
            this.amount = 100;
        } else {
            this.amount = percentage;
        }
    }

    public void strengthen() {
        System.out.println("Несколько палаток уже укреплены кубами плотного снега");
        delay();
    }
    @Override
    public String getTopic() {
        return "палаток";
    }
    @Override
    public String toString() {
        if (amount >= 0) {
            return "палаток " + convert();
        } else return convert() + " палаток";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tents t = (Tents) o;
        return Double.compare(amount, t.amount) == 0;
    }
    @Override
    public int hashCode() {
        return (int)(amount * 1e10);
    }
}
