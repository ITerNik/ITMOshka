package Commands;

import Elements.Location;
import Exceptions.BadParametersException;
import Logic.IODevice;
import Logic.Manager;

public class GreaterLocationCommand extends AbstractCommand{
    private long x;
    private double y;
    private float z;
    private int count;
    public GreaterLocationCommand(IODevice io, Manager manager) {
        super(io, manager);
        parameters = new String[]{"x_coordinate", "y_coordinate", "z_coordinate"};
    }

    @Override
    protected void checkArguments(String[] param) throws BadParametersException {
        try {
            x = Long.parseLong(param[0]);
            y = Double.parseDouble(param[1]);
            z = Float.parseFloat(param[2]);
        } catch (NumberFormatException e) {
            throw new BadParametersException("Некорректный тип координат");
        }
    }

    @Override
    public void execute() {
        count = manager.countGreaterThanLocation(new Location(x, y, z));
    }

    @Override
    public String getInfo() {
        return "выводит количество элементов, значение поля location которых больше заданного";
    }

    @Override
    public String getReport() {
        return "Найдено " + count + "элементов";
    }

    @Override
    public String getName() {
        return "count_greater_than_location";
    }
}
