package Commands;

import Logic.CliHandler;
import java.util.Queue;

public class HistoryCommand extends AbstractCommand {
    private Queue<Command> commandHistory;
    private String report = "";

    public HistoryCommand(CliHandler cio, Queue<Command> commandHistory) {
        this.commandHistory = commandHistory;
        this.cio = cio;
    }

    @Override
    public void execute() {

        if (commandHistory.isEmpty()) {
            report = "Пока ни одной команды не исполнено";
            return;
        }
        for (Command command : commandHistory) {
            report += "\n" + command.getName();
        }
        report = "Выполненные команды:" + report;
    }

    @Override
    public String getName() {
        return "history";
    }

    @Override
    public String getReport() {
        return report;
    }
}
