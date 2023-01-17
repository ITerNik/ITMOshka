package Things;

import People.*;

public class Negotiations extends Communication{
    Group participants;
    Negotiations(Group participants) {
        this.participants = participants;
    }
    public String call() {
        return "начал переговоры с руководителями"  + participants.toString();
    }
}
