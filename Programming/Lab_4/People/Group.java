package People;

import Intentions.Action;
import Intentions.Decision;
import Intentions.Intention;
import Places.Place;
import Transport.Route;

public class Group {
    protected Leader[] members;
    public Group(Leader... members) {
        this.members = members;
    }
    public void setIntention(Intention intention, Action action) {
        System.out.println(this + " " + intention.getContent() + action.getContent());
    }
    public void travel(Route route) {
        Place[] res = route.getRoute();
        System.out.printf("%s должны проти путь от места: %s до места: %s\n", this, res[0], res[1]);
    }

    @Override
    public String toString() {
        String res = members[0].toString();
        for (int i = 1; i < members.length; ++i) {
            if (i != members.length - 1) {
                res += ", ";
            } else {
                res += " и ";
            }
            res += members[i];
        }
        return res;
    }
}
