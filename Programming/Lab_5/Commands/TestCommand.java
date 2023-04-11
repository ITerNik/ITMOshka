package commands;

import elements.EyeColor;
import elements.Location;
import elements.Person;
import logic.FileDevice;
import logic.IODevice;
import logic.Manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Arrays;


public class TestCommand extends AbstractCommand {
    public TestCommand(IODevice io, Manager manager) {
        super(io, manager);
    }


    @Override
    public void execute() {
        Object[] arr = new Object[4];
        arr[0] = new Person(LocalDate.now());
        arr[1] = new Location();
        System.out.println(Arrays.toString(arr));
    }

    @Override
    public String getName() {
        return "test";
    }

    @Override
    public String getInfo() {
        return "побочная команда для тестов";
    }
}
