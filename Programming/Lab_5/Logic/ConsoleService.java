package Logic;

import Commands.*;
import Exceptions.*;

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
        commandList = new HashMap<>() {
            {
                put("test", new TestCommand(fileIO, commandIO));
                put("exit", new ExitCommand(ConsoleService.this));
                put("info", new InfoCommand(commandIO, container));
                put("show", new ShowCommand(container, commandIO));
                put("insert", new InsertCommand(commandIO, container).withElements(1).withParameters(1));
                put("remove_key", new RemoveKeyCommand(commandIO, container).withParameters(1));
                put("update_id", new UpdateIdCommand(commandIO, container).withElements(1).withParameters(1));
                put("clear", new ClearCommand(commandIO, container));
                put("save", new SaveCommand(commandIO, container, fileIO));
                put("remove_lower", new RemoveLowerCommand(commandIO, container).withElements(1));
                put("history", new HistoryCommand(commandIO, history));
                put("remove_greater_key", new RemoveGreaterCommand(commandIO, container));
                put("help", new HelpCommand(commandIO, commandList));
                put("count_by_weight", new CountByWeightCommand(commandIO, container).withParameters(1));
            }
        };
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
            String[] commandLineTokens = commandIO.readLine().split("\\s+");
            String[] arguments = Arrays.copyOfRange(commandLineTokens, 1, commandLineTokens.length);
            try {
                Command current = commandList.get(commandLineTokens[0]);
                current.parseArguments(arguments);
                current.execute();
                logCommand(commandLineTokens[0]);
            } catch (NullPointerException e) {
                System.out.println("Нет такой команды");
                continue;
            } catch (NotEnoughParametersException | UnwantedParametersException
                     | NoArgumentException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
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
