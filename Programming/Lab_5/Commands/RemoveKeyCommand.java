package Commands;

import Logic.CommandLineDevice;
import Logic.Container;

public class RemoveKeyCommand extends AbstractCommand {
    public RemoveKeyCommand(CommandLineDevice commandIO, Container container) {
        this.io = commandIO;
        this.container = container;
    }

    @Override
    protected void checkArguments(String[] param) throws IllegalArgumentException {
        if (!container.containsKey(param[0])) throw  new IllegalArgumentException("Элемента с ключом " + param[0] + " не существует");
    }

    @Override
    public void execute() {
            container.remove(parameters[0]);
            io.write("Элемент " + parameters[0] + " успешно удален");
    }
}
