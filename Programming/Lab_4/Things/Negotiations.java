package Things;

import People.*;

public class Negotiations extends Communication{
    public String call(Leader lead) {
        return "начал переговоры с руководителем"  + lead;
    }
    public String call(Group participants) {
        return "начал переговоры с руководителями"  + participants;
    }
}
