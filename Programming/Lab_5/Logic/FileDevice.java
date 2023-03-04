package Logic;

import Elements.Person;

import java.io.*;
import java.util.Scanner;

public class FileDevice implements IODevice {
    private Scanner reader;
    private BufferedOutputStream output;
    public FileDevice(String fileName) throws FileNotFoundException {
        reader = new Scanner(new FileInputStream(fileName));
        output = new BufferedOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public String read() {
        return reader.next();
    }

    @Override
    public String readLine() {
        return reader.nextLine();
    }

    @Override
    public Person readNewPerson() {
        return null;
    }

    @Override
    public void write(Person element) {
        try {
            output.write(element.toJson().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void write(String text) {
        try {
            output.write(text.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
