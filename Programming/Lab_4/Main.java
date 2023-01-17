import Abstraction.*;
import Exceptions.NegativeTimeException;
import Intentions.*;
import People.*;
import Places.*;
import Things.*;
import Transport.*;

public class Main {
    public static void main(String[] args) {
        Leader narrator = new Leader("Рассказчик");
        Leader laike = new Leader("Лейк");
        Leader douglas = new Leader("Дуглас");
        Leader peabody = new Leader("Пэбоди");
        Group narratorAndPeabody = new Group(narrator, peabody);

        Base narrator_sBase = new Base(narrator, new Fuel(100));
        Base laike_sBase = new Base(laike, new Fuel(50), new Tents(50));
        Base southBase = new Base("Южная");
        Base arkham = new Base("Аркхем");

        Crew narrator_sCrew = new Crew(5, narrator_sBase, narrator, peabody);

        Discovery lake_sMission = new Discovery(new Landscape(Nature.MOUNTAIN, laike), new Landscape("Мак-Мердо", Nature.CREEK));
        PointExpedition east = new PointExpedition("Восточная");
        PointExpedition arkhamExp = new PointExpedition("Аркхем", arkham);
        Mountain newOne = new Mountain(30, 34);

        CargoPlane lake_sPlane = new CargoPlane(laike, narrator_sCrew, narrator_sBase);
        DiscoveryPlane lake_sDplane = new DiscoveryPlane(laike, lake_sMission);

        StopPoint antarctic = new StopPoint("Антарктика");

        Decision getToLaike = new Decision(lake_sPlane, Progress.ACCEPTED);
        Decision eastIssue = new Decision(east, Progress.WAITING);
        Dependency otherFuel = new Dependency(narrator_sBase.getReserves()[0], eastIssue);
        Dependency southIssue = new Dependency(southBase, eastIssue);
        Decision antarcticIssue = new Decision(antarctic, Progress.CONDITION);

        try {
            laike.sharpen(new Curiosity(), new Story(), new Hour(1, 2));
        } catch (NegativeTimeException e) {
            System.out.println("Передано отрицательное время");
        }
        laike.intend(narratorAndPeabody);
        laike.setIntention(new Plan(false), new Exploration(newOne));
        narrator.setIntention(new Plan(false), new Joining(laike));
        laike.setIntention(new Task(false), new Sending(lake_sPlane, narrator));
        narrator_sBase.findNewLocation(new Fuel(-1));

        narrator.startNegotiations(laike, douglas);
        getToLaike.voiceIssue();
        otherFuel.voiceIssue();
        eastIssue.voiceIssue();
        laike_sBase.getState(Fuel.class);
        southIssue.voiceIssue();
        lake_sDplane.move(new Landscape("Мак-Мердо", Nature.CREEK));
        narrator_sBase.prepareClose(narrator, peabody);
        antarcticIssue.voiceIssue();
        arkhamExp.hasInPath(narrator_sBase);
        narrator_sBase.getTents().strengthen();
        narrator_sCrew.finish();
        laike_sBase.getState(Tents.class);
        narrator.sendRadiogram(laike, "Через сутки мы с Пэбоди готовы вылететь на новое место");
    }
}
