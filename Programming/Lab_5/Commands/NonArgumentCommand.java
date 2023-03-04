package Commands;

abstract class NonArgumentCommand extends ArgumentCommand{
    @Override
    protected void readArgs() {
        readArgs();
        if (!arg.isEmpty()); // throw UnwantedArgumentException
    }
}
