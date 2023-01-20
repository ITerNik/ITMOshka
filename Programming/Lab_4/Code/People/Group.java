package People;

import Abstraction.Intentive;
import Abstraction.Time.Time;
import Places.Place;
import Things.Resources;
import Transport.Route;

public class Group {
    Group() {};
    protected Leader[] members;
    public Group(Leader... members) {
        this.members = members;
    }
    public void travel(Route route) {
        Place[] res = route.getRoute();
        System.out.printf("%s должны проти путь от места: %s до места: %s\n", this, res[0], res[1]);
    }
    public void joinGroup(Leader leader, Intentive intention) {
        System.out.printf("%s %s составить компанию %s\n", this, intention.voiceIntention(Gender.PLURAL), leader);
    }
    public void joinGroup(Leader leader) {
        System.out.printf("%s составили компанию %s\n", this, leader);
    }
    public void relocate(Resources res, Intentive intention) {
        System.out.printf("%s %s переместить %s на новое место\n", this, intention.voiceIntention(Gender.PLURAL), res);
    }
    public void relocate(Resources res, Intentive intention, Time time) {
        System.out.printf("%s %s %s переместить %s на новое место\n", time.getTime(), this, intention.voiceIntention(Gender.PLURAL), res);
    }
    public void relocate(Resources res) {
        System.out.printf("%s перевезли %s на новое место\n", this, res);
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
