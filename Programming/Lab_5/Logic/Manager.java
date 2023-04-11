package logic;

import elements.Location;
import elements.Person;
import exceptions.BadParametersException;
import exceptions.NonUniqueIdException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;

public class Manager {
    private Hashtable<String, Person> collection;
    private SynchronizedSet<Integer> uniqueSet = new SynchronizedSet<>();
    private LocalDateTime date;

    {
        date = LocalDateTime.now();
    }

    public Manager(Hashtable<String, Person> collection) throws NonUniqueIdException {
        this.collection = collection;
        for (String key : collection.keySet()) {
            uniqueSet.add(collection.get(key).getId());
        }
        if (!uniqueSet.checkCondition()) throw new NonUniqueIdException("В коллекции представлены повторяющиеся ID");
    }

    public class SynchronizedSet<T> {
        private TreeSet<T> unique = new TreeSet<>();

        public boolean checkCondition() {
            return unique.size() == collection.size();
        }

        public boolean add(T value) {
            return unique.add(value);
        }

        public boolean remove(T value) {
            return unique.remove(value);
        }

        public boolean replace(T oldValue, T newValue) {
            return unique.remove(oldValue) && unique.add(newValue);
        }

        public void clear() {
            unique.clear();
        }
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

    public void put(String key, Person person) {
        int currId = person.getId();
        while (!uniqueSet.add(currId)) {
            currId++;
        }
        person.setCounterId(currId);
        collection.put(key, person);
    }


    public void remove(String key) {
        uniqueSet.remove(collection.get(key).getId());
        collection.remove(key);
    }


    public void update(String key, Person person) {
        uniqueSet.replace(collection.get(key).getId(), person.getId());
        collection.replace(key, person);
    }

    public boolean containsKey(String arg) {
        return collection.containsKey(arg);
    }

    public void clear() {
        collection.clear();
        uniqueSet.clear();
    }

    public int countByWeight(double weight) {
        return getKeyIf(currKey -> Double.compare(collection.get(currKey).getWeight(), weight) == 0).size();
    }

    public ArrayList<String> findById(int id) {
        ArrayList<String> selected = getKeyIf(currKey -> collection.get(currKey).getId() == id);
        if (!selected.isEmpty()) return selected;
        else throw new BadParametersException("Элементов с таким ID не существует");
    }

    public int countGreaterThanLocation(Location location) {
        return getKeyIf(currKey -> {
            Location curr = collection.get(currKey).getLocation();
            return curr != null && curr.compareTo(location) > 0;
        }).size();
    }

    public ArrayList<Person> filterByLocation(Location location) {
        ArrayList<String> selected = getKeyIf(currKey -> {
            Location curr = collection.get(currKey).getLocation();
            return curr != null && curr.equals(location);
        });
        ArrayList<Person> res = new ArrayList<>();
        if (selected.isEmpty()) throw new IllegalArgumentException("Элементов с такой локацией не существует");
        else {
            for (String key : selected) {
                res.add(collection.get(key));
            }
            return res;
        }
    }


    public ArrayList<String> removeGreater(String key) {
        ArrayList<String> removed = getKeyIf(currKey -> currKey.compareTo(key) > 0);
        for (String currKey : removed) {
            uniqueSet.remove(collection.get(currKey).getId());
            collection.remove(currKey);
        }
        return removed;
    }

    public ArrayList<String> removeLower(Person element) {
        ArrayList<String> removed = getKeyIf(currKey -> collection.get(currKey).compareTo(element) < 0);
        for (String currKey : removed) {
            uniqueSet.remove(collection.get(currKey).getId());
            collection.remove(currKey);
        }
        return removed;
    }

    public Hashtable<String, Person> getCollection() {
        return collection;
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
        for (String key : collection.keySet()) {
            res += String.format("Человек \"%s\":\n%s\n\n", key, collection.get(key));
        }
        return res;
    }
}
