package Intentions;

import People.Leader;

public class Joining extends Action{
    public Joining(Leader lead) {
        content = "составить компанию руководителю " + lead;
    }
}
