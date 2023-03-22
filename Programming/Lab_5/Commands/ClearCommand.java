package Commands;

import Logic.CommandLineDevice;
import Logic.Container;

public class ClearCommand extends AbstractCommand {
    public ClearCommand(CommandLineDevice io, Container container) {
        this.io = io;
        this.container = container;
    }
    @Override
    public void execute() {
        container.clear();
        io.write("Коллекция очищена");
    }
}
