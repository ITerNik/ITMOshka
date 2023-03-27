package Commands;

import Logic.CliHandler;
import Logic.Manager;

public class CountByWeightCommand extends AbstractCommand {
    private double weight;
    private int count;

    public CountByWeightCommand(CliHandler cio, Manager manager) {
        super(cio, manager);
        parameters = new String[1];
    }

    @Override
    protected void checkArguments(String[] param) throws IllegalArgumentException {
        try {
            weight = Double.parseDouble(param[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Вес должен быть числом");
        }
    }

    @Override
    public void execute() {
        count = manager.countByWeight(weight);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getReport() {
        return String.format("В коллекции найдено %s элементов с весом %s", count, weight);
    }
}
