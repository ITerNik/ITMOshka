package logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileDevice extends IODevice {

    public FileDevice(String fileName) throws FileNotFoundException {

        super(new Scanner(new FileInputStream(fileName)));
    }

    @Override
    protected String checkField(String fieldName, ValidChecker checker) {
            try {
                String field = input.nextLine();
                checker.checkValue(field);
                return field;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат числа");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        return null;
    }

    public boolean hasNextLine() {
        return input.hasNextLine();
    }
}
