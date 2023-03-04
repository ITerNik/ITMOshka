package Logic;

import Elements.Person;

public interface Manager {
    void erase(String key);
    void erase(Person element);
    void insert(String key, Person element);
    Person getElem(String key);
    String getInfo();
    void clear();
}
