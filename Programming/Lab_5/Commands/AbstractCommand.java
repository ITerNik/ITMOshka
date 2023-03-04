package Commands;

import Logic.Container;
import Logic.IODevice;
import Logic.Manager;

public abstract class AbstractCommand implements Command {
    protected Container container;
    protected IODevice io;
    public String getInfo() {
        return "No information";
    }
    abstract void readArgs();
}
