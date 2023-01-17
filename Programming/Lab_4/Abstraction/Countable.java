package Abstraction;

import Exceptions.NegativeTimeException;

public class Countable extends Time{
    private int number;
    private int proportion;

    private int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
    public Countable(int number) throws NegativeTimeException {
        if (number < 0) throw new NegativeTimeException("Отрицательное время");
        this.number = number;
    }
    public Countable(int number, int proportion) throws NegativeTimeException {
        if (number < 0 || proportion < 0) {
            throw new NegativeTimeException("Отрицательное время");
        }
        int gcd = gcd(number, proportion);
        this.number = number / gcd;
        this.proportion = (proportion == gcd) ? 0 : proportion / gcd;
    }
    @Override
    public String getTime() {
        if (proportion == 0) return String.valueOf(number);
        else if (number == 1 && proportion == 2) return "Пол";
        else return String.format("%d/%d ", number, proportion);
    }
}
