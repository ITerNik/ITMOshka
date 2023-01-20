package Intentions;

public class AcceptedDecision extends Intention{
    AcceptedDecision(boolean negative) {
        super(negative);
        this.content +="принял решение: ";
    }
}
