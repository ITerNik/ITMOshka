package Commands;

import Exceptions.BadParametersException;
import Logic.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ExecuteScriptCommand extends AbstractCommand {

    private ConsoleService service;
    private FileDevice fio;
    private static ArrayList<String> executedFiles = new ArrayList<>();

    @Override
    protected void checkArguments(String[] param) throws BadParametersException {
        try {
            if (executedFiles.contains(param[0])) throw new BadParametersException("Предоставленный файл цикличен");
            fio = new FileDevice(param[0]);
            executedFiles.add(param[0]);
        } catch (FileNotFoundException e) {
            throw new BadParametersException("Передан несуществующий файл");
        }
    }

    public ExecuteScriptCommand(IODevice cio, Manager manager, ConsoleService service) {
        super(cio, manager);
        this.service = service;
        parameters = new String[]{"file_name"};
    }

    @Override
    public void execute() {
        ConsoleService.CommandBuilder builder = service.new CommandBuilder(fio);
        while (fio.hasNextLine()) {
            String commandLine = fio.readLine();
            Command current = builder.build(commandLine);
            current.execute();
            io.write("Результат команды " + commandLine.split("\\s+")[0] + ":");
            io.write(current.getReport());
        }
        executedFiles.clear();
    }

    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getReport() {
        return "Скрипт успешно выполнен";
    }

    @Override
    public String argumentsInfo() {
        return "считывает и исполняет скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме";
    }
}
