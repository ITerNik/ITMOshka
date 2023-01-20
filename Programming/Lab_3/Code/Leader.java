public class Leader implements Delayable{
    private String name;
    Leader(String name) {
        this.name = name;
    }
    public void startNegotiations(Leader... participants) {
        String res = "";
        for (Leader lead: participants) {
            res += lead.toString();
            if (!lead.equals(participants[participants.length - 1])) {
                res += ", ";
            }
        }
        System.out.printf("%s и %s начинают переговоры\n", res, this);
        delay();
    }
    public void sendRadiogram(Leader to, String text) {
        System.out.printf("%s посылает радиограмму %sу с текстом:\n\"%s\"\n", this, to, text);
        delay();
    }
    @Override
    public String toString() {
        return name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leader l = (Leader) o;
        return (name.equals(l.name));
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

