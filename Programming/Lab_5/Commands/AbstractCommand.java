package Commands;

import Elements.Person;
import Exceptions.*;
import Logic.Container;
import Logic.IODevice;

public abstract class AbstractCommand implements Command {
    protected Container container;
    protected IODevice io;
    protected String[] parameters;
    protected Person[] elements;

    @Override
    public Command withElements(int number) {
        this.elements = new Person[number];
        return this;
    }

    @Override
    public Command withParameters(int number) {
        this.parameters = new String[number];
        return this;
    }

    protected void checkArguments(String[] param) throws IllegalArgumentException {
    }

    @Override
    public void parseArguments(String[] param) throws NotEnoughParametersException, UnwantedParametersException, NoArgumentException {
        if (parameters != null) {
            if (param.length == 0) throw new NoArgumentException("Команда не может принимать пустой аргумент");
            checkArguments(param);
            for (int i = 0; i < Math.max(parameters.length, param.length); ++i) {
                try {
                    parameters[i] = param[i];
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new NotEnoughParametersException("Команда принимает " + parameters.length + " аргумента");
                }
            }
        } else if (param.length != 0) throw new UnwantedParametersException("Команде не требуется аргумент");

        if (elements != null) {
            for (int i = 0; i < elements.length; ++i) {
                elements[i] = io.readNewPerson();
            }
        }
    }


    public String getInfo() {
        return "No information";
    }
}
