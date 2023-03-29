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

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getReport() {
        return "Заглядывайте еще!";
    }

    @Override
    public String getInfo() {
        return "завершает программу (без сохранения в файл)";
    }
}
