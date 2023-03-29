package Commands;

import Logic.CliDevice;
import Logic.IODevice;
import Logic.Manager;
import Logic.JsonHandler;

import java.io.IOException;

public class SaveCommand extends  AbstractCommand {
    private JsonHandler handler;
    public SaveCommand(IODevice io, Manager manager, JsonHandler handler) {
        super(io, manager);
        this.handler = handler;
    }

    @Override
    public void execute() {
        try {
            handler.clear();
            handler.writeData(manager.getCollection());
        } catch (IOException e) {
            io.write("Возникли проблемы при записи в файл");
        }
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getReport() {
        return "Коллекция успешно записана";
    }

    @Override
    public String getInfo() {
        return "сохраняет коллекцию в файл";
    }
}
