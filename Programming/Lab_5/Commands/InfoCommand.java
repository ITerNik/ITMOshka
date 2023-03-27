package Commands;

import Logic.CliHandler;
import Logic.Manager;

public class InfoCommand extends AbstractCommand {
    private String report;

    public InfoCommand(CliHandler cio, Manager manager) {
        super(cio, manager);
    }

    @Override
    public void execute() {
        report = manager.getInfo();
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getReport() {
        return report;
    }
}
