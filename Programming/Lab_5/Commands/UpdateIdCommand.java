package Commands;

import Logic.CommandLineDevice;
import Logic.Container;

public class UpdateIdCommand extends AbstractCommand {
    private int id;
    private String key;
    public UpdateIdCommand(CommandLineDevice commandIO, Container container) {
        this.io = commandIO;
        this.container = container;
    }

    @Override
    protected void checkArguments(String[] param) throws IllegalArgumentException {
        try {
            id = Integer.parseInt(param[0]);
            key = container.findById(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID должен быть целым числом");
        }
    }

    @Override
    public void execute() {
        container.update(key, elements[0]);
        io.write("Элемент " + key + " успешно изменен");
    }

}
