package Commands;

import Exceptions.NoArgumentException;

abstract class ArgumentCommand extends AbstractCommand {
    protected String arg;
    @Override
    protected void readArgs() {
        arg = io.readLine().strip();
        if (arg.isEmpty()) throw new NoArgumentException("Команда не может принимать пустой аргумент");
    }
}
