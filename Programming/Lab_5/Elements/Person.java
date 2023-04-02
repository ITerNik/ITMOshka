package elements;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import exceptions.BadParametersException;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Person implements Comparable<Person> {
    private static AtomicInteger idCounter = new AtomicInteger(0); //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private int id;
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null

    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double height; //Значение поля должно быть больше 0
    private double weight; //Значение поля должно быть больше 0
    private EyeColor eyeColor; //Поле может быть null
    private HairColor hairColor; //Поле может быть null
    private Location location; //Поле может быть null

    {
        idCounter.incrementAndGet();
        creationDate = LocalDate.now();
    }

    public Person(int id, String name, Coordinates coordinates, LocalDate date, double height, double weight, EyeColor eyeColor, HairColor hairColor, Location location) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = date;
        this.height = height;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.location = location;
    }

    public Person(String name, Coordinates coordinates, double height, double weight, EyeColor eyeColor, HairColor hairColor, Location location) {
        this.id = idCounter.get();
        this.name = name;
        this.coordinates = coordinates;
        this.height = height;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.location = location;
    }


    public Person() {
    }


    @Override
    public String toString() {
        return String.format("ID: %s\nИмя: %s\nКоординаты: %s\nДата создания: %s\nРост: %s\nВес: %s\nЦвет глаз: %s\n" +
                "Цвет волос: %s\nМестоположение: %s", id, name, coordinates, creationDate, height, weight, eyeColor, hairColor, location);
    }

    public Location getLocation() {
        return location;
    }

    public Integer getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public double getHeight() {
        return height;
    }


    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public HairColor getHairColor() {
        return hairColor;
    }


    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCounterId(int id) {
        this.id = id;
        idCounter.set(id);
    }


    @Override
    public int compareTo(Person o) {
        int res = Double.compare(height, o.height);
        if (res == 0) {
            res = Double.compare(weight, o.weight);
        }
        if (res == 0) {
            res = name.compareTo(o.name);
        }
        return res;
    }
}

