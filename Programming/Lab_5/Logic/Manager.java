package Logic;

import Elements.Location;
import Elements.Person;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
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
        return getKeyIf(currKey -> Double.compare(collection.get(currKey).getWeight(), weight) == 0).size();
    }

    public ArrayList<String> findById(int id) {
        ArrayList<String> selected = getKeyIf(currKey -> collection.get(currKey).getId() == id);
        if (!selected.isEmpty()) return selected;
        else throw new IllegalArgumentException("Элементов с таким ID не существует");
    }

    public int countGreaterThanLocation(Location location) {
        return getKeyIf(currKey -> collection.get(currKey).getLocation().compareTo(location) > 0).size();
    }

    public ArrayList<Person> filterByLocation(Location location) {
        ArrayList<String> selected = getKeyIf(currKey -> collection.get(currKey).getLocation() == location);
        ArrayList<Person> res = new ArrayList<>();
        if (selected.isEmpty()) throw new IllegalArgumentException("Элементов с такой локацией не существует");
        else {
            for (String key: selected) {
                res.add(collection.get(key));
            }
            return res;
        }
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


    private ArrayList<String> getKeyIf(Predicate<? super String> filter) {
        ArrayList<String> selected = new ArrayList<>();
        for (String currKey : collection.keySet()) {
            if (filter.test(currKey)) {
                selected.add(currKey);
            }
        }
        return selected;
    }

    public ArrayList<String> removeGreater(String key) {
        ArrayList<String> removed = getKeyIf(currKey -> currKey.compareTo(key) < 0);
        for (String currKey: removed) {
            collection.remove(currKey);
        }
        return removed;
    }

    public ArrayList<String> removeLower(Person element) {
        ArrayList<String> removed = getKeyIf(currKey -> collection.get(currKey).compareTo(element) > 0);
        for (String currKey: removed) {
            collection.remove(currKey);
        }
        return removed;
    }
}
