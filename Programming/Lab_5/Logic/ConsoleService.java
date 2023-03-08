package Logic;

import Commands.*;
import Elements.Person;

import java.util.*;

public class ConsoleService implements Service {
    private boolean connect;
    private ArrayList<String> history = new ArrayList<>(8);
    private Container container;
    private CommandLineDevice commandIO;
    private HashMap<String, Command> commandList;
    public ConsoleService(CommandLineDevice commandIO, Container container) {
        this.container = container;
        this.commandIO = commandIO;
         commandList = new HashMap<>(
                Map.of(
                        "info", new InfoCommand(commandIO, container)
                )
        );
         commandList.put("help", new HelpCommand(commandList, commandIO));
    }
    private void logCommand(String commandName) {
        if (history.size() >= 8) {
            history.remove(0);
        }
        history.add(commandName);
    }
    @Override
    public void start() {
        connect = true;
        commandIO.write("Welcome!");
        while (connect) {
            String commandName = commandIO.read();
            try {
                commandList.get(commandName).execute();
            } catch (NullPointerException e) {
                System.out.println("Нет такой команды");
                continue;
            }
        }
    }
}
