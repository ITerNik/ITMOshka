package Commands;

import Elements.Person;
import Logic.CommandLineDevice;
import Logic.FileDevice;

public class TestCommand extends NonArgumentCommand {
    private FileDevice fileIO;
    private CommandLineDevice commandIO;
    public TestCommand(FileDevice fileIO, CommandLineDevice commandIO) {
        this.fileIO = fileIO;
        this.commandIO = commandIO;
    }
    @Override
    public void execute() {

    }
}
