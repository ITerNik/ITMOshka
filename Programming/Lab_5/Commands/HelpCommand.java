package Commands;

import Logic.IODevice;

import java.util.Map;

public class HelpCommand extends ArgumentCommand {
    private Map<String, Command> commandList;
    public HelpCommand(Map<String, Command> commandList, IODevice io) {
        this.commandList = commandList;
        this.io = io;
    }
    public void execute() {
        for (Command command: commandList.values()) {
            io.write(command.getInfo());
        }
    }
}
