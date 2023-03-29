package Elements;

public enum EyeColor {
    GREEN("Зеленый"),
    RED("Красный"),
    BLACK("Черный"),
    BLUE("Синий"),
    YELLOW("Желтый");

    private String name;

    EyeColor(String name) {
        this.name = name;
    }

    public static EyeColor getByNumber(int number) {
        try {
            return EyeColor.values()[number - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Нет такого цвета");
        }
    }


    public static void checkColor(String field) {
        try {
            int number = Integer.parseInt(field);
            EyeColor test = EyeColor.values()[number - 1];
        } catch (NumberFormatException e) {
            throw e;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Нет такого цвета");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
