package com.emilg1101;

public class PlayerApp extends Application {

    public static void main(String[] args) {
        new PlayerApp();
    }

    @Override
    public void init() {
        super.init();
        addCommand("/add", new CommandListener() {
            @Override
            public void response(String[] params) {
                System.out.println("add command");
            }
        });
        addCommand("/playlist create", new CommandListener() {
            @Override
            public void response(String[] params) {
                System.out.println("playlist create command");
            }
        });
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void error(String e) {
        System.out.println("error: " + e);
    }
}