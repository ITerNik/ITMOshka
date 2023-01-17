package Intentions;

import Abstraction.*;

public class Dependency extends Issue implements Delayable {
    private Decision dependsOf;
    public Dependency(Solvable topic, Decision depends){
        this.topic = topic;
        this.dependsOf = depends;
    }
    @Override
    public void voiceIssue() {
        System.out.printf("Вопрос о %s зависит от %s\n", topic.getTopic(), dependsOf);
        delay();
    }
    @Override
    public String toString() {
        return "решения относительно " + topic.getTopic();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dependency d = (Dependency) o;
        return (topic.equals(d.topic)) && (dependsOf.equals(d.dependsOf));
    }
    @Override
    public int hashCode() {
        int result = topic.hashCode();
        result = 29 * result + dependsOf.hashCode();
        return result;
    }
}
