package Places;

public class Mountain extends Place {
    public Mountain(int higher, int lower) {
        this.higher = higher;
        this.lower = lower;
    }
    int higher, lower;
    public String getHight() {
        return String.format("высота колеблется от %d до %d тысяч футов",higher, lower);
    }
    static class Peaks extends Place {
        public static void stab() {
            System.out.println("Вершины вспарывали небо");
        }

        @Override
        public String toString() {
            return "Вершины";
        }

    }
    static class Foot {
        @Override
        public String toString() {
            return "Подножие";
        }
    }
    static class Slope {
        @Override
        public String toString() {
            return "Склоны";
        }
    }
    static class Layer {
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
