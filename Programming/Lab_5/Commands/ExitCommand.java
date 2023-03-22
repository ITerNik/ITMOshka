package Commands;

import Logic.Service;

public class ExitCommand extends AbstractCommand {
    private Service service;
    public ExitCommand(Service service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.exit();
    }
}
