package Commands;

import Elements.Person;
import Logic.CliHandler;
import Logic.FileDevice;


public class TestCommand extends AbstractCommand {
    private FileDevice fio;

    public TestCommand(FileDevice fio, CliHandler cio) {
        this.fio = fio;
        this.cio = cio;
        parameters = new String[3];
    }

    @Override
    public void execute() {
    }

    @Override
    public String getName() {
        return "test";
    }
}
