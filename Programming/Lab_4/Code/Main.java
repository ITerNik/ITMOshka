import Abstraction.*;
import Abstraction.Feelings.*;
import Abstraction.Time.*;
import Exceptions.NegativeTimeException;
import Intentions.*;
import People.*;
import Places.*;
import Places.Nature.*;
import Things.*;
import Transport.*;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        Leader narrator = new Leader("Рассказчик");
        Leader laike = new Leader("Лейк");
        Leader douglas = new Leader("Дуглас");
        Leader peabody = new Leader("Пэбоди");
        Leader multon = new Leader("Мултон");
        Leader estwood = new Leader("Эствуд");
        Group narratorAndPeabody = new Group(narrator, peabody);

        Base narrator_sBase = new Base(narrator, new Fuel(Resources.Amount.LIMIT));
        Base laike_sBase = new Base(laike, new Fuel(Resources.Amount.ENOUGH), new Tents(Resources.Amount.ENOUGH));
        Base southBase = new Base("Южная");
        Base arkham = new Base("Аркхем");

        Crew narrator_sCrew = new Crew(5, narrator_sBase, narrator, peabody);

        Discovery lake_sMission = new Discovery(new Mountain(), new Creek("Мак-Мердо"));
        DirectExpedition east = new DirectExpedition(Direction.EAST);
        PointExpedition east1 = new PointExpedition("Восточная");
        PointExpedition arkhamExp = new PointExpedition("Аркхем", arkham);
        Mountain newOne = new Mountain(30, 34);

        CargoPlane lake_sPlane = new CargoPlane(laike, narrator_sCrew, narrator_sBase);
        DiscoveryPlane lake_sDplane = new DiscoveryPlane(laike, lake_sMission);
        CargoPlane multon_splane = new CargoPlane(multon);

        StopPoint antarctic = new StopPoint("Антарктика");
        Wreckage multon_sPlaneWreckage = new Wreckage(multon_splane, Thickness.VERY_THIN);

        try {
            Field field = Fuel.class.getDeclaredField("getTopic");
        }
        Decision getToLaike = new Decision(lake_sPlane, Progress.ACCEPTED);
        Decision eastIssue = new Decision(east1, Progress.WAITING);
        Dependency otherFuel = new Dependency(narrator_sBase.getReserves()[0], eastIssue);
        Dependency southIssue = new Dependency(southBase, eastIssue);
        Decision antarcticIssue = new Decision(antarctic, Progress.CONDITION);

        try {
            new Story(laike).sharpen(new Curiosity(), narratorAndPeabody, new Countable.Hour(1, 2));
        } catch (NegativeTimeException e) {
            System.out.println("Не бывает отрицательного времени!");
        }
        laike.explore(newOne, Responsibility::plan);
        narrator.joinGroup(laike, Responsibility::plan);
        laike.send(lake_sPlane, Responsibility::setTask, narrator_sBase);
        narrator.joinGroup(laike, Responsibility::must);
        narratorAndPeabody.relocate(new Fuel(), Responsibility::makeDecision, new Uncountable.Before());
        laike_sBase.startWorks();
        lake_sDplane.becomeFrequent();
        narrator.send(new Fuel(Resources.Amount.MOST), Responsibility::makeDecision, laike_sBase);
        laike.setUp(new Landscape() {
            @Override
            public String toString() {
                return "Подножие гор" + name;
            }
            public void surround(Leader lead) {
                System.out.println(lead + " окружен красотой подножия гор");
            }
        }, Responsibility::plan);
        try {
            east.delay(new Countable.Year(1));
        }catch (NegativeTimeException e) {
            System.out.println("Не бывает отрицательного времени!");
        }

        getToLaike.voiceIssue();
        otherFuel.voiceIssue();
        eastIssue.voiceIssue();

        laike_sBase.getState(Fuel.class);
        southIssue.voiceIssue();
        lake_sDplane.move(new Creek("Мак-Мердо"));
        narrator_sBase.prepareClose(narratorAndPeabody);
        antarcticIssue.voiceIssue();
        arkhamExp.hasInPath(narrator_sBase);
        narrator_sBase.getTents().strengthen();
        narrator_sCrew.finish();
        laike_sBase.getState(Tents.class);
        narrator.communicate(new Radiogram(" ___. . ._. . __..   ... .._ _ _._ ..   __ _.__  " +
                " ...  .__. .._.. _... ___ _.. ..   __. ___ _ ___ .__ _.__   .__ _.__ ._.. . _ . _ _.._ " +
                "  _. ._   _. ___ .__ ___ .   __ . ... _ ___ "), laike);
    }
}
