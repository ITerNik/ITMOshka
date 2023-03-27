package Logic;

import Commands.*;
import Exceptions.*;

import java.util.*;

public class ConsoleService implements Service {
    private boolean connect;
    private Queue<Command> history = new LinkedList<>();
    private Manager manager;
    private CliHandler cio;
    private FileDevice fio;
    private CommandBuilder builder;

    public ConsoleService(CliHandler commandIO, Manager manager, FileDevice fileIO) {
        this.manager = manager;
        this.cio = commandIO;
        this.fio = fileIO;
        this.builder = new CommandBuilder(cio);
    }

    private class CommandBuilder {
        private HashMap<String, Command> commandList = new HashMap<>();
        private IODevice io;

        public CommandBuilder(IODevice io) {
            this.io = io;
            initialize();
        }

        public void addCommand(Command command) {
            commandList.put(command.getName(), command);
        }

        private void initialize() {
            addCommand(new ExitCommand(ConsoleService.this));
            addCommand(new ClearCommand(cio, manager));
            addCommand(new TestCommand(fio, cio));
            addCommand(new InfoCommand(cio, manager));
            addCommand(new ShowCommand(cio, manager));
            addCommand(new InsertCommand(cio, manager));
            addCommand(new RemoveKeyCommand(cio, manager));
            addCommand(new UpdateIdCommand(cio, manager));
            addCommand(new SaveCommand(cio, manager, fio));
            addCommand(new RemoveLowerCommand(cio, manager));
            addCommand(new HistoryCommand(cio, history));
            addCommand(new RemoveGreaterCommand(cio, manager));
            addCommand(new HelpCommand(cio, commandList));
            addCommand(new CountByWeightCommand(cio, manager));
        }

        public Command build(String line) throws NoSuchCommandException, BadParametersException {
            try {
                String[] tokens = line.split("\\s+");
                return commandList.get(tokens[0]).parseArguments(Arrays.copyOfRange(tokens, 1, tokens.length));
            } catch (NullPointerException e) {
                throw new NoSuchCommandException("Нет такой команды");
            }
        }
    }


    private void logCommand(Command command) {
        if (history.size() >= 8) {
            history.remove();
        }
        history.add(command);
    }

    @Override
    public void start() {
        connect = true;
        cio.write("Добро пожаловать!");
        while (connect) {
            try {
                cio.write("Пожалуйста, введите команду:");
                String commandLine = cio.readLine();
                Command current = builder.build(commandLine);
                current.execute();
                cio.write(current.getReport());
                logCommand(current);
            } catch (NoSuchCommandException | BadParametersException e) {
                cio.write(e.getMessage());
            }
        }
        cio.write("Заглядывайте еще!");
    }

    @Override
    public void exit() {
        connect = false;
    }
}
