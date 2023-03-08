package Elements;

import Exceptions.UnexistingColorException;

public enum HairColor {
    ORANGE("Рыжий"),
    WHITE("Седой"),
    BROWN("Брюнет");

    private String name;

    HairColor(String name) {
        this.name = name;
    }

    public static HairColor getByNumber(int number) throws UnexistingColorException {
        try {
            return HairColor.values()[number - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new UnexistingColorException("Нет такого цвета");
        }
    }

    public static void checkColor(String field) {
        try {
            int number = Integer.parseInt(field);
            HairColor test = HairColor.values()[number - 1];
        } catch (NumberFormatException e) {
            throw e;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new UnexistingColorException("Нет такого цвета");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
