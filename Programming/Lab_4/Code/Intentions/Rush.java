package Intentions;

import People.Leader;

public class Rush extends Intention{
    Rush(boolean negative, Leader lead) {
        super(negative);
        content += "поторопил руководителя " + lead + " ";
    }
}
