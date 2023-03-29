package Commands;

import Elements.Location;
import Elements.Person;
import Exceptions.BadParametersException;
import Logic.IODevice;
import Logic.Manager;

import java.util.ArrayList;

public class FilterByLocationCommand extends AbstractCommand{
    private long x;
    private double y;
    private float z;
    private ArrayList<Person> selected;
    public FilterByLocationCommand(IODevice io, Manager manager) {
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
        selected = manager.filterByLocation(new Location(x, y, z));
    }

    @Override
    public String getInfo() {
        return "выводит элементы, значение поля location которых равно заданному";
    }

    @Override
    public String getReport() {
        return "Найденные элементы:\n" + selected;
    }

    @Override
    public String getName() {
        return "filter_by_location";
    }
}
