package Commands;

import Logic.CommandLineDevice;
import Logic.Container;

public class RemoveLowerCommand extends AbstractCommand {
    public RemoveLowerCommand(CommandLineDevice io, Container container) {
        this.io = io;
        this.container = container;
    }

    @Override
    public void execute() {
        io.write(container.removeLower(elements[0]));
    }
}
