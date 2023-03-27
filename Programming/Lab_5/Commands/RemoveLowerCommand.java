package Commands;

import Logic.CliHandler;
import Logic.Manager;

import javax.naming.ldap.PagedResultsControl;
import java.util.ArrayList;

public class RemoveLowerCommand extends AbstractCommand {
    private ArrayList<String> removed;
    public RemoveLowerCommand(CliHandler cio, Manager manager) {
        super(cio, manager);
        parameters = new String[1];
    }

    @Override
    public void execute() {
        removed = manager.removeLower(elements[0]);
    }

    @Override
    public String getName() {
        return "remove_lower";
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
