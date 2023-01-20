package Transport;

public enum Direction {
    NORTH("Север"),
    SOUTH("Юг"),
    EAST("Восток"),
    WEST("Запад");
    private String name;
    Direction(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
