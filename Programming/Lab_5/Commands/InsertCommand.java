package Commands;

import Logic.CommandLineDevice;
import Logic.Container;

public class InsertCommand extends BothCommand {
    public InsertCommand(CommandLineDevice commandIO, Container container) {
        this.io = commandIO;
        this.container = container;
    }
    @Override
    public void execute() {
        arg = io.read();
        io.readLine();
        if (container.containsKey(arg)) {
            System.out.println("Элемент с ключом " + arg + " уже существует");
            return;
        }
        element = io.readNewPerson();
        container.put(arg, element);
        io.write("Элемент " + arg + " добавлен");
    }
}
