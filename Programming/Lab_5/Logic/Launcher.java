package Logic;

import Elements.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class Launcher {

    public static void main(String[] args) {
        try {
            FileDevice fileIO = new FileDevice("test.json");
            HashMap<String, Person> collection = fileIO.readCollection();
            Container container = new Container(collection);
            Service app = new ConsoleService(new CommandLineDevice(), container, fileIO);
            //Service app = new ConsoleService(new CommandLineDevice(), new Container(new HashMap()), new FileDevice("test.json"));
            app.start();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Неверный формат данных в файле");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Необходимо передать название файла в аргументах");
        }

    }

}
