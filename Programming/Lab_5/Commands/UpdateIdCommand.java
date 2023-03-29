package Commands;


import Logic.IODevice;
import Logic.Manager;

import java.util.ArrayList;

public class UpdateIdCommand extends AbstractCommand {
    private int id;
    private ArrayList<String> keys;

    public UpdateIdCommand(IODevice io, Manager manager) {
        super(io, manager);
        parameters = new String[]{"id"};
    }

    @Override
    protected void checkArguments(String[] param) throws IllegalArgumentException {
        try {
            id = Integer.parseInt(param[0]);
            keys = manager.findById(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID должен быть целым числом");
        }
    }

    @Override
    public void execute() {
        for (String key : keys) {
            manager.update(key, elements[0]);
        }
    }

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getReport() {
        return "Измененные элементы:\n" + keys;
    }

    @Override
    public String getInfo() {
        return "обновляет значение элемента коллекции, id которого равен заданному";
    }
}
