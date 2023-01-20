package Places.Nature;

import People.Leader;
import Places.Place;

public class Mountain extends Landscape {
    public Mountain(int higher, int lower) {
        super("Новые");
        this.higher = higher;
        this.lower = lower;
    }
    public Mountain(int higher, int lower, String name) {
        super(name);
        this.higher = higher;
        this.lower = lower;
    }
    public Mountain() {
        super("Новые");
    }
    int higher, lower;
    public void surround(Leader lead) {
        System.out.println(lead + " окружен красотой гигантов " + name);
    }
    public String getHight() {
        return String.format("высота колеблется от %d до %d тысяч футов",higher, lower);
    }

    public class Peaks extends Mountain {
        public static void stab() {
            System.out.println("Вершины вспарывали небо");
        }

        @Override
        public String toString() {
            return "Вершины гор " + name;
        }

    }
    public class Foot extends Mountain{
        @Override
        public String toString() {
            return "Подножие гор " + name;
        }
    }
    public class Slope extends Mountain {
        @Override
        public String toString() {
            return "Склоны гор" + name;
        }
    }
     public class Layer extends Mountain {
        @Override
        public String toString() {
            return "Слои";
        }
    }

    @Override
    public String toString() {
        return "горы";
    }
}
