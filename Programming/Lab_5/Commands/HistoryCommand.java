package Commands;

import Logic.CommandLineDevice;

import java.util.List;

public class HistoryCommand extends AbstractCommand {
    private List<String> commandHistory;
    public HistoryCommand(CommandLineDevice io, List<String> commandHistory) {
        this.commandHistory = commandHistory;
        this.io = io;
    }
    @Override
    public void execute() {
        try {
            String res = commandHistory.get(0);
            for (int i = 1; i < commandHistory.size(); ++i) {
                res += ",\n" + commandHistory.get(i);
            }
            io.write("Выполненные команды:\n" + res);
        } catch (IndexOutOfBoundsException e) {
            io.write("Пока ни одной команды не исполнено");
        }
    }
}
