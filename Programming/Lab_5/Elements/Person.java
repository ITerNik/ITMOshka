package Elements;

public class Person {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double height; //Значение поля должно быть больше 0
    private double weight; //Значение поля должно быть больше 0
    private EyeColor eyeColor; //Поле может быть null
    private HairColor hairColor; //Поле может быть null
    private Location location; //Поле может быть null
    public Person(String name,Coordinates coordinates, double height, double weight) {
        this.name = name;
        this.coordinates = coordinates;
        this.height = height;
        this.weight = weight;
    }
    public Person(String name,Coordinates coordinates, double height, double weight, EyeColor eyeColor, HairColor hairColor, Location location){
        this(name, coordinates, height, weight);
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.location = location;
    }
    @Override
    public String toString() {
        return String.format("Имя: %s\nКоординаты: %s\nРост: %s\nВес: %s\nЦвет глаз: %s\n" +
                "Цвет волос: %s\nМестоположение: %s", name, coordinates, height, weight, eyeColor, hairColor, location);
    }
    public String toJson() {
        return String.format("{\n\"Имя\": %s,\n\"Координаты\": %s,\n\"Рост\": %s,\n\"Вес\": %s,\n\"Цвет глаз\": %s,\n" +
                "\"Цвет волос\": %s,\n\"Местоположение\": %s\n}", name, coordinates.toJson(), height, weight, eyeColor, hairColor, location.toJson());
    }
}

