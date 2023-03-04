package Logic;

import Elements.Person;

import java.io.IOException;

public interface IODevice {
    String read();
    String readLine();
    Person readNewPerson();
    void write(String text);
    void write(Person element);
}
