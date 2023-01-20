package Intentions;

import Places.Place;
import Transport.*;

public class Transportation extends Action {
    Transportation(CargoPlane plane, Place to) {
        content += String.format("отправить %s c %s на место: %s", plane, plane.onBoard(), to);
    }
}
