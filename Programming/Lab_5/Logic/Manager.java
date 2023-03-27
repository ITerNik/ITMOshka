package Logic;

import Elements.Person;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.function.Predicate;

public class Manager {
    private Hashtable<String, Person> collection;
    private LocalDateTime date;

    {
        date = LocalDateTime.now();
    }

    public Manager(Hashtable collection) {
        this.collection = collection;
    }

    public String getInfo() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm:ss");
        return String.format("Тип коллекции: %s\nХранимые экземпляры: %s\nДата инициализации: %s\nКоличество элементов: %d",
                collection.getClass().getSimpleName(), "Person", date.format(format), collection.size());
    }

    public void update(String key, Person person) {
        collection.replace(key, person);
    }

    public int countByWeight(double weight) {
        int count = 0;
        for (String key: collection.keySet()) {
            if (collection.get(key).getWeight() == weight) {
                count++;
            }
        }
        return count;
    }

    public String findById(int id) {
        for (String key: collection.keySet()) {
            if (collection.get(key).getId() == id) return key;
        }
        throw new IllegalArgumentException("Элемента с таким ID не существует");
    }

    @Override
    public String toString() {
        if (collection.isEmpty()) {
            return "Коллекция пуста";
        }
        String res = "";
        for (String key : collection.keySet()) {
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
        collection.remove(key);
    }

    public void clear() {
        collection.clear();
    }

    public Hashtable<String, Person> getCollection() {
        return collection;
    }

    private ArrayList<String> removeIf(Predicate<? super String> filter) {
        ArrayList<String> removed = new ArrayList<>();
        for (String currKey: collection.keySet()) {
            if (filter.test(currKey)) {
                collection.remove(currKey);
                removed.add(currKey);
            }
        }
        return removed;
    }
    public ArrayList<String> removeGreater(String key) {
        return removeIf(currKey -> currKey.compareTo(key) < 0);
    }
    public ArrayList<String> removeLower(Person element) {
       return removeIf(currKey -> collection.get(currKey).compareTo(element) > 0);
    }
}
