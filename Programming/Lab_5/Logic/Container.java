package Logic;

import Elements.Person;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Container {
    private HashMap<String, Person> collection = new HashMap<>();
    private LocalDateTime date;
    {
        date = LocalDateTime.now();
    }

    public String getInfo() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm:ss");
        return String.format("Тип коллекции: %s\nХранимые экземпляры: %s\nДата инициализации: %s\nКоличество элементов: %d",
                collection.getClass().getSimpleName(),"Person" ,date.format(format) , collection.size());
    }
}
