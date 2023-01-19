package People;

import Abstraction.*;
import Abstraction.Feelings.Feeling;
import Exceptions.ExistingBaseException;
import Places.*;
import Places.Nature.*;
import Things.*;
import Transport.*;

public class Leader {
    private String name;
     public class Voice{
         public void through(Landscape land) {
            System.out.printf("Голос руководителя %s пробился сквозь местность: %s", name, land);
        }
         public void feel(Feeling feeling) {
             System.out.printf("В голосе руководителя %s улавливалось %s", name, feeling);
         }
    }
    public Leader(String name) {
        this.name = name;
    }

    public void send(Transferable item, Place location){
        System.out.printf("%s отправить %s на место: %s\n", this, item, location);
    }
    public void send(Transferable item, Intentive intention, Place location){
        System.out.printf("%s %s отправить %s на место: %s\n", this, intention.voiceIntention(Gender.MALE), item, location);
    }
    public void explore(Landscape land) {
        System.out.printf("%s освоил местность: %s\n", this, land);
    }
    public void explore(Landscape land, Intentive intention) {
        System.out.printf("%s %s освоить местность: %s\n", this, intention.voiceIntention(Gender.MALE), land);
    }
    public void joinGroup(Leader leader, Intentive intention) {
        System.out.printf("%s %s составить компанию руководителю %s\n", this, intention.voiceIntention(Gender.MALE), leader);
    }
    public void joinGroup(Leader leader) {
        System.out.printf("%s составил компанию руководителю %s\n", this, leader);
    }
    public Base setUp(String name, Fuel fuel, Tents tents) {
        Base newOne = new Base(name, this, fuel, tents);
        System.out.printf("%s основал новое место: %s\n", this, newOne);
        return newOne;
    }
    public void setUp(Place location, Intentive intention) {
        System.out.printf("%s %s разбить новую базу на месте: %s\n", this, intention.voiceIntention(Gender.MALE), location);
        if (location instanceof Base) {
            throw new ExistingBaseException("База уже существует");
        }
    }
    public void relax() {
        System.out.println(this + " решил отдохнуть");
    }
    public void communicate(Communication device, Leader lead) {
        System.out.printf(this + " " + device.call(lead));
    }
    public void communicate(Communication device, Group participants) {
        System.out.printf(this + " " + device.call(participants));
    }
    public void communicate() {
        System.out.println(this + " вышел на связь");
    }
    public void feel(Feeling feeling) {
        System.out.printf("%s ощущал %s", this, feeling);
    }
    public void feel(Feeling feeling, Landscape from) {
        System.out.printf("%s ощущал %s от %s", this, feeling, from);
    }
    public void calculate(Mountain mountain) {
        System.out.printf("%s расчитал, что %s", this, mountain.getHight());
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

