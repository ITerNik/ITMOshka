package Commands;

import Logic.Container;
import Logic.IODevice;

public class InfoCommand extends AbstractCommand {
    public InfoCommand(IODevice io, Container container) {
        this.io = io;
        this.container = container;
    }
    @Override
    public void execute() {
        io.write(container.getInfo());
    }
}
