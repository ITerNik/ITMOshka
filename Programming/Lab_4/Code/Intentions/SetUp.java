package Intentions;

import Places.Place;

public class SetUp extends Action{
    public SetUp(Place location) {
        content = "разбить новый лагерь в месте: " + location;
    }
}
