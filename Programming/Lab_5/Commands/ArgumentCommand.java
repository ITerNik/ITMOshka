package Commands;

abstract class ArgumentCommand extends AbstractCommand {
    protected String arg;
    @Override
    protected void readArgs() {
        arg = io.readLine().strip();
    }
}
