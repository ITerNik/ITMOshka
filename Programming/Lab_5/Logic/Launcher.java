package logic;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Launcher {

    public static void main(String[] args) {
        try (JsonHandler handler = new JsonHandler("test.json");
             CliDevice cio = new CliDevice()) {
            Manager manager = new Manager(handler.readCollection());
            Service app = new ConsoleService(cio, manager, handler);
            app.start();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (JsonProcessingException e) {
            System.out.println("Невозможно десериализовать данные в файле");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Необходимо передать название файла в аргументах");
        } catch (IOException e) {
            System.out.println("Поток для работы с файлом не закрыт");
        }

    }

}
