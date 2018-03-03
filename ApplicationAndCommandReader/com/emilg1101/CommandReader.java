package com.emilg1101;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandReader {

    private Scanner scanner;
    private Map<String, CommandListener> commandSet;
    private ErrorListener errorListener;

    public CommandReader() {
        scanner = new Scanner(System.in);
        commandSet = new HashMap<>();
    }

    public void setErrorListener(ErrorListener errorListener) {
        this.errorListener = errorListener;
    }

    public void addCommand(String command, CommandListener commandListener) {
        commandSet.put(command, commandListener);
    }

    public void listen() {
        String line;
        String[] data;
        while (true){
            line = scanner.nextLine();
            if (line.isEmpty()) break;
            data = line.split(" ");
            String command;
            String[] params;

            if (data.length > 1 && commandSet.containsKey(data[0] + " " + data[1])) {
                command = data[0] + " " + data[1];
                params = getParams(data, 2);
            } else if (commandSet.containsKey(data[0])) {
                command = data[0];
                params = getParams(data, 1);
            } else {
                errorListener.error("Command not found");
                continue;
            }

            commandSet.get(command).response(params);
        }
    }

    private String[] getParams(String[] data, int start) {
        String[] params = new String[data.length - start];
        for (int i = 0; i < params.length; i++) {
            params[i] = data[i + start];
        }
        return params;
    }

    interface ErrorListener {
        void error(String e);
    }
}
