package Logic;

import java.io.FileNotFoundException;

public class Launcher {

    public static void main(String[] args) {
        try {
            Service app = new ConsoleService(new CommandLineDevice(), new Container(), new FileDevice("C:\\Users\\terni\\OneDrive\\Рабочий стол\\Test.txt"));
            app.start();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Необходимо передать название файла в аргументах");
        }

    }

}
