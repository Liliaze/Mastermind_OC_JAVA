package game;

import java.util.Scanner;

import game.constante.GameColor;
import game.constante.GameMode;
import game.constante.GameType;


public class Menu {

    public void displayWelcomeMenu() {
        System.out.println("Hello new Challenger, welcome in Boudy Game !");
        displayGameChoice();
        displayModeChoice();
    }

    private void displayGameChoice() {
        final StringBuilder msgChoice = new StringBuilder("Please enter number :" );

        for (GameType game : GameType.values()) {
            msgChoice.append(" ").append(game.getNumber()).append(" for ").append(game);
        }
        int nbScan;

        System.out.println("Which game do you want to play :");
        for (GameType game : GameType.values()) {
            GameColor.BLUE.print(game.getNumber() + ") ", false);
            System.out.println(game + " : " + game.getDescription());
        }
        do {
            System.out.println(msgChoice);
            nbScan = scanInt();
        } while ((GameState.gameChoosed = GameType.convertFromInt(nbScan)) == null);
        if (GameState.gameChoosed == GameType.EXIT) {
            displayGoodBye();
        }
    }

    private void displayModeChoice() {
        final StringBuilder msgChoice = new StringBuilder("Please enter number :" );

        for (GameMode mode : GameMode.values()) {
            msgChoice.append(" - ").append(mode.getNumber()).append(" for ").append(mode);
        }
        int nbScan;

        System.out.println("You choice '" + GameState.gameChoosed + "' game !");
        System.out.println("Please now choose your MODE : ");
        for (GameMode mode : GameMode.values()) {
            GameColor.BLUE.print(mode.getNumber() + ") ", false);
            System.out.println(mode + " : " + mode.getDescription());
        }

        do {
            System.out.println(msgChoice);
            nbScan = scanInt();
        } while ((GameState.modeChoosed = GameMode.convertFromInt(nbScan)) == null);
        if (GameState.modeChoosed == GameMode.EXIT) {
            displayGoodBye();
        }
    }

    public int again() {
        int answer;

        do {
            System.out.println("\nMake your choice :");
            GameColor.BLUE.print("1) ", false);
            System.out.println("PLAY AGAIN");
            GameColor.BLUE.print("2) ", false);
            System.out.println("MENU");
            GameColor.BLUE.print("3) ", false);
            System.out.println("EXIT");
            answer = scanInt();
        } while (answer < 1 || answer > 3);
        return answer;
    }

    public static void displayGoodBye() {
        System.out.println("GOOD_BYE");
        System.exit(0);
    }


    private int scanInt() {
        final Scanner sc = new Scanner(System.in);

        try {
            return sc.nextInt();
        }
        catch (Exception e) {
        }
        return 0;
    }
}
