package Logic;

import Elements.Coordinates;
import Elements.Location;
import Elements.Person;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLOutput;
import java.util.*;

public class CommandLineDevice implements IODevice {
    private Scanner sin = new Scanner(System.in);
    HashMap<String, Class> fields = new HashMap<>(
            Map.of(
                    "имя", String.class,
                    "координату x", Double.class,
                    "координату y", Integer.class,
                    "рост", Double.class,
                    "вес", Double.class,
                    "цвет волос:\n1. Рыжий\n2. Седой\n3. Брюнет", Integer.class,
                    "цвет глаз:\n1. Зеленый\n2. Красный\n3. Черный\n4. Синий\n5. Желтый", Integer.class,
                    "местоположение x", Long.class,
                    "местоположение y", Double.class,
                    "местоположение z", Float.class
            )
    );
    ArrayList<String> index = new ArrayList<>(fields.keySet());

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
        int i = 0;
        while (i < index.size() - 1) {
            Class check = fields.get(index.get(i));
            try {
                System.out.printf("Введите %s: ", index.get(i));
                    check.getMethod("parse" + check.getSimpleName().strip(), check).invoke(sin.nextLine());
                i++;
                System.out.println();
            } catch (ClassCastException e) {
                System.err.println("\nНекорректный ввод");
            } catch (NoSuchMethodException | IllegalAccessException |InvocationTargetException e) {
                if (check.equals(String.class)) {

                } else {
                    System.err.println("Системная ошибка");
                }
            }
        }
        return null;
    }
    private boolean checkValue() {
        return  true;
    }

    private Coordinates readNewCoordinates() {
        return null;
    }

    private String readValue(String pattern) {
        String res = "" ;
        while (sin.hasNextLine()) {
            try {
                res = sin.next(pattern);
                break;
            } catch (InputMismatchException e) {
                System.out.print("Некорректный ввод. Повторите попытку: ");
                res = sin.nextLine();
            }
        }
        return res;
    }

    private Location readNewLocation() {
        System.out.print("Введите x: ");
        long x = sin.nextLong();
        System.out.print("\nВведите y: ");
        double y = sin.nextDouble();
        System.out.print("\nВведите z: ");
        float z = sin.nextFloat();
        return new Location(x, y, z);
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
