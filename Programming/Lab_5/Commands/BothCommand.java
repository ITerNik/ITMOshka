package Commands;

import Elements.Person;

abstract class BothCommand extends ArgumentCommand {
    protected Person element;
    @Override
    protected void readArgs() {
        super.readArgs();
        element = io.readNewPerson();
    }
}
