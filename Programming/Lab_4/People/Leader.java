package People;

import Abstraction.*;
import Intentions.*;
import Places.*;
import Things.*;

public class Leader implements Delayable {
    private String name;
     class Voice{
         public void through(Landscape land) {
            System.out.printf("Голос руководителя %s пробился сквозь местность: %s", getName(), land);
        }
         public void feel(Feeling feeling) {
             System.out.printf("В голосе руководителя %s улавливалось %s", getName(), feeling);
         }
    }
    public Leader(String name) {
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
    private String getName() {
         return name;
    }
    public void relax() {
        System.out.println(this + " решил отдохнуть после тяжелого дня");
    }
    public void communicate(Communication device, Leader lead) {
        System.out.printf("%s %s руководителя %s\n", this, device.call(), lead);
    }
    public void communicate() {
        System.out.println(this + " вышел на связь");
    }
    public void surrounded(Sharable by) {
        System.out.println(this + " окружен " + by);
    }
    public void feel(Feeling feeling) {
        System.out.printf("%s ощущал %s", this, feeling);
    }
    public void feel(Feeling feeling, Landscape from) {
        System.out.printf("%s ощущал %s от %s", this, feeling, from);
    }
    public void sharpen(Feeling feeling, Sharable by) {
        System.out.printf("%s усиливал чувство %s, используя %s\n", this, feeling, by);
    }
    public void sharpen(Feeling feeling, Sharable by, Time time) {
        System.out.print(time.getTime() + " ");
        sharpen(feeling, by);
    }
    public void calculate(Mountain mountain) {
        System.out.printf("%s расчитал, что %s", this, mountain.getHight());
    }
    public void intend(Group with) {
        System.out.printf("%s поделился намерением c руководителями %s\n", this, with);
    }
    public void intend(Leader with) {
        System.out.printf("%s поделился намерением c руководителем %s\n", this, with);
    }
    public void setIntention(Intention intention, Action action) {
        System.out.println(this + " " + intention.getContent() + action.getContent());
    }
    public void sendRadiogram(Leader to, String text) {
        System.out.printf("%s посылает радиограмму командиру %s с текстом:\n\"%s\"\n", this, to, text);
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

