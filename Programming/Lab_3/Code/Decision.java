public class Decision extends Issue implements Delayable {
    private Progress progress;

    Decision(Solvable topic, Progress progress) {
        this.topic = topic;
        this.progress = progress;
    }

    @Override
    public void voiceIssue() {
        // Исправить в соответствии с принципом Open-Close
        switch (progress) {
            case WAITING:
                System.out.printf("Решение относительно %s отложено на несколько дней\n", topic.getTopic());
                break;
            case ACCEPTED:
                System.out.println("Принято решение: " + topic.getTopic());
                break;
            case CONDITION:
                System.out.printf("Даже если решение относительно %s будет принято: ", topic.getTopic());
                break;
        }
        delay();
    }
    @Override
    public String toString() {
        return "решения относительно " + topic.getTopic();
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Decision d = (Decision) o;
        return (topic.equals(d.topic)) && (progress.equals(d.progress));
    }
    @Override
    public int hashCode() {
        int result = topic.hashCode();
        result = 29 * progress.hashCode();
        return result;
    }
}
