package Logic;

import Commands.*;
import Exceptions.*;

import java.io.FileNotFoundException;
import java.util.*;

public class ConsoleService implements Service {
    private boolean connect;
    private Queue<Command> history = new LinkedList<>();
    private Manager manager;
    private CliDevice cio;
    private JsonHandler handler;
    private CommandBuilder builder;

    public ConsoleService(CliDevice commandIO, Manager manager, JsonHandler handler) throws FileNotFoundException {
        this.manager = manager;
        this.cio = commandIO;
        this.handler = handler;
        this.builder = new CommandBuilder(cio);
    }

    public class CommandBuilder {
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
            addCommand(new ClearCommand(io, manager));
            addCommand(new TestCommand(io, manager));
            addCommand(new InfoCommand(io, manager));
            addCommand(new ShowCommand(io, manager));
            addCommand(new InsertCommand(io, manager));
            addCommand(new RemoveKeyCommand(io, manager));
            addCommand(new UpdateIdCommand(io, manager));
            addCommand(new SaveCommand(io, manager, handler));
            addCommand(new RemoveLowerCommand(io, manager));
            addCommand(new HistoryCommand(io, history));
            addCommand(new RemoveGreaterCommand(io, manager));
            addCommand(new HelpCommand(io, commandList));
            addCommand(new CountByWeightCommand(io, manager));
            addCommand(new ExecuteScriptCommand(io, manager, ConsoleService.this));
            addCommand(new GreaterLocationCommand(io, manager));
            addCommand(new FilterByLocationCommand(io, manager));
        }

        public Command build(String line) throws NoSuchCommandException, BadParametersException {
            String[] tokens = line.split("\\s+");
            try {
                return commandList.get(tokens[0]).parseArguments(Arrays.copyOfRange(tokens, 1, tokens.length));
            } catch (NullPointerException e) {
                throw new NoSuchCommandException("Не существует команды " + tokens[0]);
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
                cio.write(current.getReport() + "\n");
                logCommand(current);
            } catch (NoSuchCommandException | BadParametersException e) {
                cio.write(e.getMessage() + "\n");
            } catch (NoSuchElementException e) {
                connect = false;
            }
        }
    }

    @Override
    public void exit() {
        connect = false;
    }
}
