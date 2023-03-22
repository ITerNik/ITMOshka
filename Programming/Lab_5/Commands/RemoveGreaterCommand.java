package Commands;

import Logic.CommandLineDevice;
import Logic.Container;

public class RemoveGreaterCommand extends AbstractCommand {
    public RemoveGreaterCommand(CommandLineDevice commandIO, Container container) {
        this.io = commandIO;
        this.container = container;
    }

    @Override
    public void execute() {
        io.write(container.removeGreater(parameters[0]));
    }
}
