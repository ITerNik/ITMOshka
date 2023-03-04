package Elements;

public enum HairColor {
    ORANGE("Рыжий"),
    WHITE("Седой"),
    BROWN("Брюнет");
    private String name;
    HairColor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
