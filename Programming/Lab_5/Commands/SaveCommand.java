package Commands;

import Elements.Person;
import Logic.CommandLineDevice;
import Logic.Container;
import Logic.FileDevice;

import java.io.FileReader;
import java.io.IOException;

public class SaveCommand extends  AbstractCommand {
    private FileDevice fileIO;
    public SaveCommand(CommandLineDevice commandIO, Container container, FileDevice fileIO) {
        this.io = commandIO;
        this.fileIO = fileIO;
        this.container = container;
    }

    @Override
    public void execute() {
        try {
            fileIO.clear();
            fileIO.writeData(container.getCollection());
            io.write("Коллекция успешно записана");
        } catch (IOException e) {
            io.write("Возникли проблемы при записи в файл");
        }

    }
}
