package Logic;

import java.util.*;

public class CliDevice extends IODevice {

    public CliDevice() {
        super(new Scanner(System.in));
    }

    @Override
    protected String checkField(String fieldName, ValidChecker checker) {
        while (true) {
            try {
                System.out.printf("Введите %s: ", fieldName);
                String field = input.next();
                checker.checkValue(field);
                return field;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат числа");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
