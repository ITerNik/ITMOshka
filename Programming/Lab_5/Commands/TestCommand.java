package Commands;

import Elements.Person;
import Logic.FileDevice;
import Logic.IODevice;
import Logic.Manager;


public class TestCommand extends AbstractCommand {
    public TestCommand(IODevice io, Manager manager) {
        super(io,manager);
        elements = new Person[1];
    }

    @Override
    public void execute() {
        io.write(elements[0]);
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
