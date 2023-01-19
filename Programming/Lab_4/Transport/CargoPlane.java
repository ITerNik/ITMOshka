package Transport;

import Intentions.*;
import People.*;
import Places.*;
import Things.*;

public class CargoPlane extends Plane implements Solvable {
    private Crew passengers;
    private Resources[] cargo;
    CargoPlane(Leader owner, Crew passengers, Resources[] cargo, Base location) {
        this.owner = owner;
        this.passengers = passengers;
        this.cargo = cargo;
        this.location = location;
    }
    public CargoPlane(Leader owner, Crew passengers, Base location) {
        this(owner, passengers, location.getReserves(), location);
    }
    public CargoPlane(Leader owner) {
        this.owner = owner;
    }
    public String onBoard() {
        String res = "";
        for (Resources r: cargo) {
                if (!r.equals(cargo[0])) {
                    res += ", ";
                }
                res += r.getState();
        }
        return String.format("%s на борту, а также с %s в грузовом отсеке", passengers.getMembers(), res);
    }
    public String getFlight(Place to) {
        return String.format("%s летит на %s, с %s", this, to, this.onBoard());
    }
    public String getFlight() {
        return String.format("%s летит на %s, с %s", this, new Base(owner, new Fuel()), this.onBoard());
    }
    @Override
    public void move(Place to) {
        System.out.println(this.getFlight(to));
        passengers.move(to);
        if (location.getClass() == Base.class && to.getClass() == Base.class){
            Base base = (Base)location;
            base.moveReserves((Base)to);
        }
        location = to;
    }
    @Override
    public String getTopic() {
        return this.getFlight();
    }
    @Override
    public String toString() {
        return "Самолет руководителя " + owner;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargoPlane cp = (CargoPlane) o;
        return (passengers.equals(cp.passengers)) && (cargo.equals(cp.cargo));
    }
    @Override
    public int hashCode() {
        int result = cargo == null ? 0 : cargo.hashCode();
        result = 29 * result + passengers.hashCode();
        return result;
    }
}
