package Intentions;

import People.*;

class Work extends Action{
    public Work() {
        content = "проводить взрывные и буровые работы";
    }
    public void start(Leader lead) {
        System.out.println("Начались буровые работы руководителя " + lead);
    }
}

