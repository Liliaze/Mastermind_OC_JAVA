package com.company;

import java.util.Scanner;

import com.company.gameConstante.GameMode;
import com.company.gameConstante.GameType;

import static com.company.gameConstante.GameType.*;
import static com.company.gameConstante.GameMode.*;


public class Menu {

    public void displayWelcomeMenu() {
        System.out.println("Hello new Challenger, welcome in Boudy Game !");
        displayGameChoice();
        displayModeChoice();
    }

    private void displayGameChoice() {
        String msgChoice = ("Please enter number " + PLUS_AND_MINUS.getGameNumber() + " for '" + PLUS_AND_MINUS +
                "' or number "+ MASTERMIND.getGameNumber() + " for '" + MASTERMIND + "' : ");
        int nbScan;

        System.out.println("Which game do you want to play :");
        System.out.println(PLUS_AND_MINUS.getGameNumber() + ") SEARCH PLUS or MINUS, find the secretCode with plus and minus.");
        System.out.println(MASTERMIND.getGameNumber() + ") MASTERMIND, find the secretCode with mysterious indication.");
        do {
            System.out.println(msgChoice);
            nbScan = scanInt();
        } while ((GameState.gameChoosed = GameType.convertFromInt(nbScan)) == null);
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
        String msgChoice = ("Please enter number " + CHALLENGER.getModeNumber() + " for " + CHALLENGER + " or " +
        DEFENDER.getModeNumber() + " for " + DEFENDER + " or " +
        DUAL.getModeNumber() + " for " + DUAL + "." );
        int nbScan;

        System.out.println("You choice '" + GameState.gameChoosed + "' game !");
        System.out.println("Please now choose your MODE : ");
        System.out.println(CHALLENGER.getModeNumber() + ") " + CHALLENGER + " : xxxxxxx TO DO DSC" );
        System.out.println(DEFENDER.getModeNumber() + ") " + DEFENDER + " : xxxxxxx TO DO DSC" );
        System.out.println(DUAL.getModeNumber() + ") " + DUAL + " : xxxxxxx TO DO DSC" );
        do {
            System.out.println(msgChoice);
            nbScan = scanInt();
        } while ((GameState.modeChoosed = GameMode.convertFromInt(nbScan)) == null);
    }

/*
    private void displayMastermindRules() {
        System.out.println("YOU ARE IN MASTERMIND GAME - This is Rules");
    }

    private void displayPlusAndMinusRules() {
        System.out.println("YOU ARE IN PLUS AND MINUS GAME - This is Rules");
    }
*/
    public boolean again() {
        char answerChar;
        do {
            System.out.println("Do you want play again ? (Y or N)");
            answerChar = scanChar();
        } while (answerChar != 'Y' && answerChar != 'N' && answerChar != 'y' && answerChar != 'n');

        return (answerChar == 'Y' || answerChar == 'y');
    }

    public void displayGoodBye() {
        System.out.println("GOOD_BYE");
        System.exit(0);
    }
}
