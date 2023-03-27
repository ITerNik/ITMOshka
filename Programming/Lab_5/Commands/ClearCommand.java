package Commands;

import Logic.CliHandler;
import Logic.Manager;

public class ClearCommand extends AbstractCommand {
    public ClearCommand(CliHandler io, Manager manager) {
        super(io, manager);
    }
    @Override
    public void execute() {
        manager.clear();
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getReport() {
        return "Коллекция очищена";
    }
}
