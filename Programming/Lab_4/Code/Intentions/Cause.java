package Intentions;

import Intentions.Issue;
import Intentions.Solvable;

public class Cause extends Issue {
    private Solvable cause;
    public Cause(Solvable topic, Solvable cause) {
        this.topic = topic;
        this.cause = cause;
    }
    @Override
    public void voiceIssue() {
        System.out.printf("%s, в связи с чем %s", topic.getTopic(), cause.getTopic());
    }
}
