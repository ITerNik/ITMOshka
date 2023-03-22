package Commands;

import Elements.Person;
import Exceptions.NoArgumentException;
import Exceptions.NotEnoughParametersException;
import Exceptions.UnwantedParametersException;

public interface Command {

    Command withElements(int number);

    Command withParameters(int number);

    void parseArguments(String[] params) throws NotEnoughParametersException,
            UnwantedParametersException, NoArgumentException;


    void execute();

    String getInfo();

}
