package Intentions;

public class Obligation extends Intention {
    Obligation(boolean negative) {
        super(negative);
        content += "должен ";
    }
}
