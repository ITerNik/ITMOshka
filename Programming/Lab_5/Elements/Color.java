package Elements;

public enum Color {
    GREEN("Зеленый"),
    RED("Красный"),
    BLACK("Черный"),
    BLUE("Синий"),
    YELLOW("Желтый");
    private String name;
    Color(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
