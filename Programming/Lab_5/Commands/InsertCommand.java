package Commands;

import Logic.CliHandler;
import Logic.Manager;

public class InsertCommand extends AbstractCommand {
    public InsertCommand(CliHandler cio, Manager manager) {
        super(cio, manager);
        parameters = new String[1];
    }

    @Override
    protected void checkArguments(String[] param) throws IllegalArgumentException {
        if (manager.containsKey(param[0]))
            throw new IllegalArgumentException("Элемент с ключом " + param[0] + " уже существует");
    }

    @Override
    public void execute() {
        manager.put(parameters[0], elements[0]);
    }

    @Override
    public String getName() {
        return "insert";
    }

    @Override
    public String getReport() {
        return "Элемент " + parameters[0] + " добавлен";
    }
}
