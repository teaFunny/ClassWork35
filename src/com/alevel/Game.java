package com.alevel;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Tamagochi tamagochi = new Tamagochi();
        Thread tamagochiThread = new Thread(tamagochi);
        tamagochiThread.setDaemon(true);
        System.out.println("Start the game");
        tamagochiThread.start();

        Scanner scanner = new Scanner(System.in);

        while (tamagochiThread.isAlive()){
            int command = scanner.nextInt();
            doSomething(command, tamagochi);
        }

        //System.out.println("You are loose");
        scanner.close();


    }

    private static void doSomething(int commandNumber, Tamagochi tamagochi) {
        switch (commandNumber) {
            case 1:
                tamagochi.clean();
                break;
            case 2:
                tamagochi.feed();
                break;
            case 3:
                tamagochi.play();
                break;
            case 4:
                tamagochi.sleep();
                break;
                default:
                    throw new IllegalArgumentException("Invalid command");


        }
    }
}
