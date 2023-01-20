package Abstraction.Time;

import Exceptions.NegativeTimeException;

public abstract class Countable extends Time {
    private int number;
    private int proportion = 1;

    private int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
    private Countable(int number) throws NegativeTimeException {
        if (number < 0) throw new NegativeTimeException("Отрицательное время");
        this.number = number;
    }
    private Countable(int number, int proportion) throws NegativeTimeException {
        if (number < 0 || proportion < 0) {
            throw new NegativeTimeException("Отрицательное время");
        }
        int gcd = gcd(number, proportion);
        this.number = number / gcd;
        this.proportion = (proportion == gcd) ? 0 : proportion / gcd;
    }
    @Override
    public String getTime() {
        if (proportion == 1) return String.valueOf(number);
        else if (number == 1 && proportion == 2) return "пол";
        else return String.format("%d/%d ", number, proportion);
    }
    public static class Hour extends Countable{
        public Hour(int number) throws NegativeTimeException {
            super(number);
        }
        public Hour(int number, int proportion) throws NegativeTimeException {
            super(number, proportion);
        }
        @Override
        public String getTime() {
            try {
                int number = Integer.valueOf(super.getTime());
                String res = number + switch (number % 10) {
                    case 1: yield " час";
                    case 2, 3, 4: yield " часа";
                    default: yield " часов";
                };
                return res;
            } catch (NumberFormatException e) {
                return super.getTime() + "часа";
            }
        }
    }
    public static class Year extends Countable {
        public Year(int number) throws NegativeTimeException {
            super(number);
        }
        public Year(int number, int proportion) throws NegativeTimeException {
            super(number, proportion);
        }
        @Override
        public String getTime() {
            try {
                int number = Integer.valueOf(super.getTime());
                String res = number + switch (number % 10) {
                    case 1: yield " год";
                    case 2, 3, 4: yield " года";
                    default: yield " лет";
                };
                return res;
            } catch (NumberFormatException e) {
                return super.getTime() + "года";
            }
        }
    }
}
