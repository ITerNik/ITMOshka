package commands;

import logic.IODevice;
import logic.Manager;

public class ShowCommand extends AbstractCommand {
    private String report;
    public ShowCommand(IODevice io, Manager manager) {
        super (io, manager);
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

    @Override
    public String getInfo() {
        return "выводит в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
