package Logic;

import Elements.*;
import Exceptions.NameFormatException;
import Exceptions.UnexistingColorException;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLOutput;
import java.util.*;

public class CommandLineDevice implements IODevice {
    private Scanner sin = new Scanner(System.in);

    @Override
    public String readLine() {
        return sin.nextLine();
    }

    @Override
    public String read() {
        return sin.next();
    }

    @Override
    public Person readNewPerson() {
        return new Person(readName(), readCoordinates(), readHeight(), readWeight(),
                readEyeColor(), readHairColor(), readLocation());
    }

    private String checkField(String fieldName, ValidChecker checker) {
        while (true) {
            try {
                System.out.printf("Введите %s: ", fieldName);
                String field = sin.nextLine();
                checker.checkValue(field);
                return field;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат числа");
            } catch (NameFormatException e) {
                System.out.println("Имя должно содержать только буквенные символы");
            } catch (UnexistingColorException e) {
                System.out.println("Нет такого цвета");
            }
        }
    }

    private String readName() {
        return checkField("имя", this::checkName);

    }

    private Coordinates readCoordinates() {
        return new Coordinates(Double.parseDouble(checkField("координату x", Double::parseDouble)),
                (Integer.parseInt(checkField("координату y", Integer::parseInt))));
    }

    private double readHeight() {
        return Double.parseDouble(checkField("рост", Double::parseDouble));
    }

    private double readWeight() {
        return Double.parseDouble(checkField("вес", Double::parseDouble));
    }

    private EyeColor readEyeColor() {
        return EyeColor.getByNumber(Integer.parseInt(checkField("цвет глаз:\n1. Зеленый\n" +
                "2. Красный\n3. Черный\n4. Синий\n5. Желтый\n", EyeColor::checkColor)));
    }

    private HairColor readHairColor() {
        return HairColor.getByNumber(Integer.parseInt(checkField("цвет волос:\n1. Рыжий\n" +
                "2. Седой\n3. Брюнет\n", HairColor::checkColor)));
    }

    private Location readLocation() {
        return new Location(Long.parseLong(checkField("координату места x", Long::parseLong)),
                Double.parseDouble(checkField("координату места y", Double::parseDouble)),
                Float.parseFloat(checkField("координату места z", Float::parseFloat)));
    }
    private void checkName(String field) {
        if (!field.matches("[А-Яа-яA-Za-z\\s]*")) throw new NameFormatException("Некорректное имя");
    }

    @Override
    public void write(String text) {
        System.out.println(text);
    }

    @Override
    public void write(Person element) {
        System.out.println(element);
    }
}
