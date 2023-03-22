package Commands;

import Elements.Person;
import Logic.CommandLineDevice;
import Logic.FileDevice;

import java.io.IOException;
import java.util.Arrays;


public class TestCommand extends AbstractCommand {
    private FileDevice fileIO;
    public TestCommand(FileDevice fileIO, CommandLineDevice commandIO) {
        this.fileIO = fileIO;
        this.io = commandIO;
    }

    @Override
    public void execute() {
    }
}
