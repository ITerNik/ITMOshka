package Things;

import Intentions.Solvable;

public abstract class Resources implements Solvable {
    protected double amount;

    protected String convert() {
        if (amount > 75) {
            return "до предела";
        } else if (amount > 50 && amount <= 75) {
            return "много";
        } else if (amount <= 50 && amount > 25) {
            return "хватает";
        } else if (amount <= 25 && amount > 0) {
            return "недостаточно";
        } else if (amount == 0) {
            return "нет";
        } else return "неизвестное количество";
    }
    public void fill(double percentage) {
        if (amount + percentage > 100) {
            amount = 100;
        } else if (amount + percentage < 0) {
            amount = 0;
        } else amount += percentage;
    }
    public double getAmount() {
        return amount;
    }
}
