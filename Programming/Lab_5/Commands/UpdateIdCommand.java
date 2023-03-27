package Commands;

import Logic.CliHandler;
import Logic.Manager;

public class UpdateIdCommand extends AbstractCommand {
    private int id;
    private String key;

    public UpdateIdCommand(CliHandler cio, Manager manager) {
        super(cio, manager);
        parameters = new String[1];
    }

    @Override
    protected void checkArguments(String[] param) throws IllegalArgumentException {
        try {
            id = Integer.parseInt(param[0]);
            key = manager.findById(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID должен быть целым числом");
        }
    }

    @Override
    public void execute() {
        manager.update(key, elements[0]);
    }

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getReport() {
        return "Элемент " + key + " успешно изменен";
    }
}
