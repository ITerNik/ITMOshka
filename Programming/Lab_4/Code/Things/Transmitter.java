package Things;

import People.*;

public class Transmitter extends Communication {
    public String call(Leader lead) {
        return "вызвал по рации руководителя " + lead;
    }
    public String call(Group adressed) {
        return "вызвал по рации руководителей " + adressed;
    }
}
