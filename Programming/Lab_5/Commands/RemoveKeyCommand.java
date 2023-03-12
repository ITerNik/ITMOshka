package Commands;

import Logic.CommandLineDevice;
import Logic.Container;
import Logic.NoSuchKeyException;

public class RemoveKeyCommand extends ArgumentCommand {
    public RemoveKeyCommand(CommandLineDevice commandIO, Container container) {
        this.io = commandIO;
        this.container = container;
    }
    @Override
    public void execute() {
        readArgs();
        try {
            container.remove(arg);
            io.write("Элемент " + " успешно удален");
        } catch (NoSuchKeyException e) {
            io.write(e.getMessage());
        }
    }
}
