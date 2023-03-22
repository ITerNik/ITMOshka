package Commands;

import Exceptions.NoSuchKeyException;
import Logic.CommandLineDevice;
import Logic.Container;

public class InsertCommand extends AbstractCommand {
    public InsertCommand(CommandLineDevice commandIO, Container container) {
        this.io = commandIO;
        this.container = container;
    }

    @Override
    protected void checkArguments(String[] param) throws IllegalArgumentException {
        if (container.containsKey(param[0])) throw new IllegalArgumentException("Элемент с ключом " + param[0] + " уже существует");
    }

    @Override
    public void execute() {
        container.put(parameters[0], elements[0]);
        io.write("Элемент " + parameters[0] + " добавлен");
    }
}
