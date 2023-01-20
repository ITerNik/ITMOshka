package Things;

import Abstraction.Feelings.Feeling;
import Abstraction.Time.Time;
import People.*;

public class Story {
    private Leader author;
    public Story(Leader author) {
        this.author = author;
    }
    public void sharpen(Feeling feel, Group of) {
        System.out.printf("%s руководителя %s разжигают чувство %s руководителей %s\n", this, author, feel, of);
    }
    public void sharpen(Feeling feel, Leader of) {
        System.out.printf("%s руководителя %s разжигают чувство %s руководителя %s\n", this, author, feel, of);
    }
    public void sharpen(Feeling feel, Group of, Time time) {
        System.out.printf("%s руководителя %s %s разжигают чувство %s руководителей %s\n", this, author, time.getTime(), feel, of);
    }
    @Override
    public String toString() {
        return "Рассказы";
    }
}
