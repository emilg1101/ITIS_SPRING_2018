package com.emilg1101;

public class Application implements CommandReader.ErrorListener {

    private CommandReader commandReader;

    Application() {
        this.commandReader = new CommandReader();
        this.commandReader.setErrorListener(this);
        this.init();
        this.start();
    }

    public void init() {
        System.out.println(this.getClass().getSimpleName() + " init()");
        addCommand("/exit", data -> System.exit(0));
    }

    public void start() {
        System.out.println(this.getClass().getSimpleName() + " start()");
        this.commandReader.listen();
    }

    public void addCommand(String command, CommandListener commandListener) {
        this.commandReader.addCommand(command, commandListener);
    }

    @Override
    public void error(String e) {
        System.out.println(e);
    }
}