package Abstraction;

import Exceptions.NegativeTimeException;

public class Hour extends Countable{
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
