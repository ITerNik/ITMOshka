package Logic;

import Commands.*;
import Exceptions.NoArgumentException;

import java.util.*;

public class ConsoleService implements Service {
    private boolean connect;
    private ArrayList<String> history = new ArrayList<>(8);
    private Container container;
    private CommandLineDevice commandIO;
    private FileDevice fileIO;
    private HashMap<String, Command> commandList;

    public ConsoleService(CommandLineDevice commandIO, Container container, FileDevice fileIO) {
        this.container = container;
        this.commandIO = commandIO;
        this.fileIO = fileIO;
        commandList = new HashMap<>(
                Map.of(
                        "info", new InfoCommand(commandIO, container),
                        "exit", new ExitCommand(this),
                        "show", new ShowCommand(container, commandIO),
                        "insert", new InsertCommand(commandIO, container),
                        "remove_key", new RemoveKeyCommand(commandIO, container),
                        "test", new TestCommand(fileIO, commandIO)
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
        commandIO.write("Добро пожаловать!");
        while (connect) {
            commandIO.write("Пожалуйста, введите команду: ");
            String commandName = commandIO.read();
            try {
                commandList.get(commandName).execute();
            } catch (NullPointerException e) {
                System.out.println("Нет такой команды");
                continue;
            } catch (NoArgumentException e) {
                System.out.println("Команда не может принимать пустой аргумент");
                continue;
            }
        }
        commandIO.write("Заглядывайте еще!");
    }

    @Override
    public void exit() {
        connect = false;
    }
}
