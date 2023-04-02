package commands;

import elements.Person;
import logic.IODevice;
import logic.Manager;


public class TestCommand extends AbstractCommand {
    public TestCommand(IODevice io, Manager manager) {
        super(io,manager);
    }

    @Override
    public void execute() {
        manager.put("New", new Person());
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
