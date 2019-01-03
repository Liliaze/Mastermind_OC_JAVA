package com.company;

import com.company.gameConstante.GameType;

import java.util.Scanner;

import static com.company.gameConstante.GameType.*;


public class Menu {
    public static GameType gameChoosed;
    //public static GameChallenge challengeChoosed;

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
        } while ((gameChoosed = GameType.convertFromInt(nbScan)) == null);
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

    public void displayWelcomeMenu() {
        System.out.println("Hello new Challenger, welcome in Boudy Game !");
        displayGameChoice();
        displayChallengeChoice();/*
        switch (gameChoosed) {
            case PLUS_AND_MINUS:
                displayPlusAndMinusMenu();
                break;
            case MASTERMIND:
                displayMastermindMenu();
                break;
            default:
                displayGoodBye();
                break;
        }*/
    }

    private void displayChallengeChoice() {
        System.out.println("YOU ARE IN '" + gameChoosed + "' GAME, ENJOY !");
        System.out.println("TO DO : Possibilité de choisir un type de challenge");
    }


    private void displayMastermindMenu() {
        System.out.println("YOU ARE IN MASTERMIND GAME");
    }

    private void displayPlusAndMinusMenu() {
        System.out.println("YOU ARE IN PLUS AND MINUS GAME");
    }

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
