package Commands;

import Elements.Person;
import Logic.CommandLineDevice;

import java.util.HashMap;

public class HelpCommand extends AbstractCommand {
    private HashMap<String, Command> commandList;
    public HelpCommand(CommandLineDevice io, HashMap<String, Command> commandList) {
        this.commandList = commandList;
        this.io = io;
    }
    @Override
    public void execute() {
        for (Command command : commandList.values()) {
            io.write(command.getInfo());
        }
    }
}
