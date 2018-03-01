package com.emilg1101;

import java.util.Scanner;

public class Main {

    private static TracksRepository repository;

    public static void main(String[] args) {

        repository = new TracksRepository();

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        readCommand(line.split(" "));

        while (!line.isEmpty()) {
            line = scanner.nextLine();
            String[] command = line.split(" ");
            readCommand(command);
        }
    }

    private static void readCommand(String[] command) {
        switch (command[0]) {
            case "/add":
                addCmd(command[1], Integer.parseInt(command[2]));
                break;
            case "/serialize":
                serializeCmd();
                break;
            case "/read":
                readCmd();
                break;
            case "/clear":
                clearCmd();
                break;
            default:
                System.out.println("Command not found!");
                break;
        }
    }

    private static void clearCmd() {
        repository = new TracksRepository();
        serializeCmd();
    }

    private static void readCmd() {
        repository = Serializer.deserialize(repository);
        System.out.println(repository.toString());
    }

    private static void addCmd(String title, int duration) {
        Track track = new Track(title, duration);
        repository.add(track);
        Serializer.serialize(repository);
    }

    private static void serializeCmd() {
        Serializer.serialize(repository);
        readCmd();
    }
}