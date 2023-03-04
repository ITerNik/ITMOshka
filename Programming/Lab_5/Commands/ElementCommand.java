package Commands;

import Elements.Person;

abstract class ElementCommand extends AbstractCommand {
    protected Person element;
    @Override
    void readArgs() {
        element = io.readNewPerson();
    }
}
