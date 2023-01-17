package Intentions;

public class Possibility extends Intention {
    Possibility(boolean negative) {
        super(negative);
        content += "может ";
    }
}
