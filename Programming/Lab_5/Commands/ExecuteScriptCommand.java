package commands;

import exceptions.BadParametersException;
import logic.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ExecuteScriptCommand extends AbstractCommand {

    private ConsoleService.CommandBuilder builder;
    private FileDevice fio;

    @Override
    protected void checkArguments(String[] param) throws BadParametersException {
        builder.checkFile(param[0]);
        try {
            fio = new FileDevice(param[0]);
        } catch (FileNotFoundException e) {
            throw new BadParametersException("Передан несуществующий файл");
        }
    }

    public ExecuteScriptCommand(IODevice cio, Manager manager, ConsoleService.CommandBuilder builder) {
        super(cio, manager);
        this.builder = builder;
        setParameterNames("file_name");
    }

    @Override
    public void execute() {
        while (fio.hasNextLine()) {
            String commandLine = fio.readLine();
            Command current = builder.build(commandLine);
            current.execute();
            io.write("Результат команды " + current.getName() + ":");
            io.write(current.getReport());
        }
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
    public String getInfo() {
        return "считывает и исполняет скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме";
    }
}
