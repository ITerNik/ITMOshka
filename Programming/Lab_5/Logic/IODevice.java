package Logic;

import Elements.*;

import java.util.Scanner;

public abstract class IODevice {

    protected Scanner input;

    public IODevice(Scanner input) {
        this.input = input;
    }

    public String readLine() {
        return input.nextLine();
    }

    public String read() {
        return input.next();
    }

    public Person readPerson() {
        return new Person(readName(), readCoordinates(), readHeight(), readWeight(),
                readEyeColor(), readHairColor(), readLocation());
    }

    abstract String checkField(String fieldName, ValidChecker checker);

    protected String readName() {
        return checkField("имя", this::checkName);
    }

    protected Coordinates readCoordinates() {
        return new Coordinates(Double.parseDouble(checkField("координату x", Double::parseDouble)),
                (Integer.parseInt(checkField("координату y", Integer::parseInt))));
    }

    protected double readHeight() {
        return Double.parseDouble(checkField("рост", Double::parseDouble));
    }

    protected double readWeight() {
        return Double.parseDouble(checkField("вес", Double::parseDouble));
    }

    protected EyeColor readEyeColor() {
        return EyeColor.getByNumber(Integer.parseInt(checkField("цвет глаз:\n1. Зеленый\n" +
                "2. Красный\n3. Черный\n4. Синий\n5. Желтый\n", EyeColor::checkColor)));
    }

    protected HairColor readHairColor() {
        return HairColor.getByNumber(Integer.parseInt(checkField("цвет волос:\n1. Рыжий\n" +
                "2. Седой\n3. Брюнет\n", HairColor::checkColor)));
    }

    protected Location readLocation() {
        return new Location(Long.parseLong(checkField("координату места x", Long::parseLong)),
                Double.parseDouble(checkField("координату места y", Double::parseDouble)),
                Float.parseFloat(checkField("координату места z", Float::parseFloat)));
    }

    protected void checkName(String field) {
        if (!field.matches("[А-Яа-яA-Za-z\\s]*"))
            throw new IllegalArgumentException("Имя должно содержать только буквенные символы");
    }

    public void write(String text) {
        System.out.println(text);
    }

    public void write(Person element) {
        System.out.println(element);
    }
}
