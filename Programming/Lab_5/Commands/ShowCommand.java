package Commands;

import Logic.CliHandler;
import Logic.Manager;

public class ShowCommand extends AbstractCommand {
    private String report;
    public ShowCommand( CliHandler cio, Manager manager) {
        super (cio, manager);
    }

    @Override
    public void execute() {
        report = manager.toString();
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getReport() {
        return report;
    }
}
