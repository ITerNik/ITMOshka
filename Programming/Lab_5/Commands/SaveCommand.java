package Commands;

import Logic.CliHandler;
import Logic.Manager;
import Logic.FileDevice;

import java.io.IOException;

public class SaveCommand extends  AbstractCommand {
    private FileDevice fio;
    public SaveCommand(CliHandler cio, Manager manager, FileDevice fio) {
        super(cio, manager);
        this.fio = fio;
    }

    @Override
    public void execute() {
        try {
            fio.clear();
            fio.writeData(manager.getCollection());
        } catch (IOException e) {
            cio.write("Возникли проблемы при записи в файл");
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
}
