package commands;

import exceptions.BadParametersException;

public interface Command {

    Command parseArguments(String[] param) throws BadParametersException;

    void execute();

    String getName();

    String getInfo();

    String getReport();

    String argumentsInfo();
}
