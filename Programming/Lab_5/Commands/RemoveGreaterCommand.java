package Commands;

import Logic.CliHandler;
import Logic.Manager;

import java.util.ArrayList;

public class RemoveGreaterCommand extends AbstractCommand {
    private ArrayList<String> removed;
    public RemoveGreaterCommand(CliHandler cio, Manager manager) {
        super(cio, manager);
        parameters = new String[1];
    }

    @Override
    public void execute() {
        removed = manager.removeGreater(parameters[0]);
    }

    @Override
    public String getName() {
        return "remove_greater_key";
    }

    @Override
    public String getReport() {
        if (removed.isEmpty()) {
            return "Ничего не удалено";
        } else {
            return "Удалены следующие объекты:\n" + removed;
        }
    }
}
