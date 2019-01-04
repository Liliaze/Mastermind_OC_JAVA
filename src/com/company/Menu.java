package com.company;

import java.util.Scanner;

import com.company.gameConstante.GameMode;
import com.company.gameConstante.GameType;

import static com.company.gameConstante.GameType.*;


public class Menu {

    public void displayWelcomeMenu() {
        System.out.println("Hello new Challenger, welcome in Boudy Game !");
        displayGameChoice();
        displayModeChoice();
    }

    private void displayGameChoice() {
        StringBuilder msgChoice = new StringBuilder("Please enter number :" );
        for (GameType game : GameType.values()) {
            msgChoice.append(" - ").append(game.getNumber()).append(" for ").append(game);
        }
        int nbScan;

        System.out.println("Which game do you want to play :");
        for (GameType game : GameType.values()) {
            System.out.println(game.getNumber() + ") " + game + " : " + game.getDescription());
        }
        do {
            System.out.println(msgChoice);
            nbScan = scanInt();
        } while ((GameState.gameChoosed = GameType.convertFromInt(nbScan)) == null);
        if (GameState.gameChoosed == GameType.EXIT) {
            displayGoodBye();
        }
    }

    private int scanInt() {
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        }
        catch (Exception e) {
        }
        return 0;
    }

    private char scanChar() {
        Scanner sc = new Scanner(System.in);

        try {
            String str = sc.nextLine();
            return str.charAt(0);
        } catch (Exception e) {
        }
        return '0';
    }


    private void displayModeChoice() {
        StringBuilder msgChoice = new StringBuilder("Please enter number :" );
        for (GameMode mode : GameMode.values()) {
            msgChoice.append(" - ").append(mode.getNumber()).append(" for ").append(mode);
        }
        int nbScan;

        System.out.println("You choice '" + GameState.gameChoosed + "' game !");
        System.out.println("Please now choose your MODE : ");
        for (GameMode mode : GameMode.values()) {
            System.out.println(mode.getNumber() + ") " + mode + " : " + mode.getDescription());
        }

        do {
            System.out.println(msgChoice);
            nbScan = scanInt();
        } while ((GameState.modeChoosed = GameMode.convertFromInt(nbScan)) == null);
        if (GameState.modeChoosed == GameMode.EXIT) {
            displayGoodBye();
        }
    }

/*
    private void displayMastermindRules() {
        System.out.println("YOU ARE IN MASTERMIND GAME - This is Rules");
    }

    private void displayPlusAndMinusRules() {
        System.out.println("YOU ARE IN PLUS AND MINUS GAME - This is Rules");
    }
*/

    public int again() {
        String msg = "Make your choice :\n" +
        "1) PLAY AGAIN\n" +
        "2) MENU\n" +
        "3) EXIT";
        int answer;

        do {
            System.out.println(msg);
            answer = scanInt();
        } while (answer < 1 || answer > 3);
        return answer;
    }
/*
    private String again(String msg) {
        System.out.println(msg);
        char answerChar;
        do {
            answerChar = scanChar();
        } while (answerChar != 'Y' && answerChar != 'N' && answerChar != 'y' && answerChar != 'n');
        return (answerChar == 'Y' || answerChar == 'y');
    }
*/
    public void displayGoodBye() {
        System.out.println("GOOD_BYE");
        System.exit(0);
    }
}
