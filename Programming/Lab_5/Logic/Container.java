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
                collection.getClass().getSimpleName(), "Person", date.format(format), collection.size());
    }

    @Override
    public String toString() {
        if (collection.isEmpty()) {
            return "Коллекция пуста";
        }
        String res = "";
        for (String key: collection.keySet()) {
            res += String.format("Человек \"%s\": \n%s\n\n", key, collection.get(key));
        }
        return res;
    }

    public void put(String key, Person person) {
        collection.put(key, person);
    }

    public boolean containsKey(String arg) {
        return collection.containsKey(arg);
    }
    public void remove(String key) {
        if (!collection.containsKey(key)) {
            throw new NoSuchKeyException("Не существует элемента с этим ключом");
        }
        collection.remove(key);
    }
}
