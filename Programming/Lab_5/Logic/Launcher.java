package Logic;

public class Launcher {

    public static void main(String[] args) {
        Service app = new ConsoleService(new CommandLineDevice(), new Container());
        app.start();
    }

}
