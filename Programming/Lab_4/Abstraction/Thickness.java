package Abstraction;

public enum Thickness {
    VERY_THICK("Очень толстый"),
    THICK("Толстый"),
    MEDIUM("Средней толщины"),
    THIN("Тонкий"),
    VERY_THIN("Очень тонкий");

    private String name;
    Thickness(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
