package commands;

import elements.Person;
import logic.IODevice;
import logic.Manager;

import java.time.LocalDate;


public class InsertCommand extends AbstractCommand {
    public InsertCommand(IODevice io, Manager manager) {
        super(io, manager);
        setParameterNames("key");
        setElements(new Person(LocalDate.now()));
    }

    @Override
    protected void checkArguments(String[] param) throws IllegalArgumentException {
        if (manager.containsKey(param[0]))
            throw new IllegalArgumentException("Элемент с ключом " + param[0] + " уже существует");
    }

    @Override
    public void execute() {
        manager.put(parameters[0], (Person) elements[0]);
    }

    @Override
    public String getName() {
        return "insert";
    }

    @Override
    public String getReport() {
        return "Элемент " + parameters[0] + " добавлен";
    }

    @Override
    public String getInfo() {
        return "добавляет новый элемент с заданным ключом";
    }
}
