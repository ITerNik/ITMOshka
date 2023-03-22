package Commands;

import Logic.CommandLineDevice;
import Logic.Container;

public class CountByWeightCommand extends AbstractCommand {
    private double weight;

    public CountByWeightCommand(CommandLineDevice commandIO, Container container) {
        this.io = commandIO;
        this.container = container;
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
        io.write(String.format("В коллекции найдено %s элементов с весом %s", container.countByWeight(weight), weight));
    }
}
