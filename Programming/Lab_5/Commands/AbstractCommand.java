package commands;

import elements.Person;
import exceptions.*;
import logic.IODevice;
import logic.Manager;

public abstract class AbstractCommand implements Command {
    protected Manager manager;
    protected IODevice io;
    protected String[] parameters;
    protected Person[] elements;

    public AbstractCommand() {
    }

    public AbstractCommand(IODevice io, Manager manager) {
        this.manager = manager;
        this.io = io;
    }

    protected void checkArguments(String[] param) throws BadParametersException {
    }

    protected void setParameterNames(String... names) {
        parameters = names;
    }

    protected void setElementNumber(int number) {
        elements = new Person[number];
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
                elements[i] = io.readPerson();
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

    @Override
    public String argumentsInfo() {
        String res = "";
        if (parameters != null) {
            for (String param : parameters) {
                res += " " + param;
            }
        }
        if (elements != null) {
            for (int i = 0; i < elements.length; ++i) {
                res += " {element}";
            }
        }
        return res;
    }
}
