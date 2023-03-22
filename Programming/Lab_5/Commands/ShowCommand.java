package Commands;

import Elements.Person;
import Logic.CommandLineDevice;
import Logic.Container;

public class ShowCommand extends AbstractCommand {
    public ShowCommand(Container container, CommandLineDevice commandIO) {
        this.container = container;
        this.io = commandIO;
    }

    @Override
    public void execute() {
        io.write(container.toString());
    }
}
