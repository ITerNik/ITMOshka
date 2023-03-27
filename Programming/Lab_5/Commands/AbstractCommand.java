package Commands;

import Elements.Person;
import Exceptions.*;
import Logic.CliHandler;
import Logic.Manager;

import java.util.Arrays;

public abstract class AbstractCommand implements Command {
    protected Manager manager;
    protected CliHandler cio;
    protected String[] parameters;
    protected Person[] elements;

    public AbstractCommand() {}

    public AbstractCommand(CliHandler cio, Manager manager) {
        this.manager = manager;
        this.cio = cio;
    }

    protected void checkArguments(String[] param) throws IllegalArgumentException {
    }

    @Override
    public Command parseArguments(String[] param) throws BadParametersException {
        if (parameters != null) {
            if (param.length == 0) throw new BadParametersException("Команда не может принимать пустой аргумент");
            checkArguments(param);
            for (int i = 0; i < Math.max(parameters.length, param.length); ++i) {
                try {
                    parameters[i] = param[i];
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new BadParametersException("Команда принимает " + parameters.length + " аргумент(а)");
                }
            }
        } else if (param.length != 0) throw new BadParametersException("Команде не требуется аргумент");

        if (elements != null) {
            for (int i = 0; i < elements.length; ++i) {
                elements[i] = cio.readNewPerson();
            }
        }
        return this;
    }

    @Override
    public String getInfo() {
        return "No information";
    }

    @Override
    public String getReport() {
        return "Команда успешно выполнена";
    }
}
