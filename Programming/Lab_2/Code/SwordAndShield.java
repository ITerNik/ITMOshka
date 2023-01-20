import ru.ifmo.se.pokemon.*;
import Pokemons.*;

public class SwordAndShield {
    public static void main(String[] args) {
        Battle b = new Battle();
        Pokemon teamMembers[] = new Pokemon[]{new Bellsprout("Горошек", 20),
                new Jirachi("Звездочка", 20), new Rapidash("Жэрэбэц", 40),
                new Ponyta("Поняш", 30), new Victreebel("Мухолов", 21),
                new Weepinbell("Горохострел", 21)};

        int amount = 6;
        while (amount > 0) {
            int index = (int)((Math.random() * 5.9));
            if (teamMembers[index] != null) {
                if (amount > 3) {
                    b.addAlly(teamMembers[index]);
                } else {
                    b.addFoe(teamMembers[index]);
                }
                teamMembers[index] = null;
                amount--;
            }
        }

        b.go();
    }
}
