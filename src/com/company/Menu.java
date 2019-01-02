package com.company;

import com.company.gameConstante.GameType;

import java.util.Scanner;

import static com.company.gameConstante.GameType.*;


public class Menu {
    public GameType gameChoosed;

    private void displayGameChoice() {
        System.out.println("A quel jeu voulez-vous jouer :");
        System.out.println(PLUS_AND_MINUS.getGameNumber() + ") SEARCH PLUS or MINUS, find the secretCode with plus and minus.");
        System.out.println(MASTERMIND.getGameNumber() + ") MASTERMIND, find the secretCode with misterious indication.");
        getAnswer("Please enter number " + PLUS_AND_MINUS.getGameNumber() + " for '" + PLUS_AND_MINUS +
                "' or number "+ MASTERMIND.getGameNumber() + " for '" + MASTERMIND + "' : ");
    }

    private void getAnswer(String msgErrorInput) {
        Scanner sc = new Scanner(System.in);
        try {
            int nb = sc.nextInt();
            if ((gameChoosed = GameType.convertFromInt(nb)) == null) {
                System.out.println(msgErrorInput);
                getAnswer(msgErrorInput);
            }
        } catch (Exception e) {
            System.out.println(msgErrorInput);
            getAnswer(msgErrorInput);
        }
    }

    public void displayWelcomeMenu() {
        System.out.println("Hello new Challenger, welcome in Boudy Game !");
        displayGameChoice();
        displayChallengeMenu();/*
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

    private void displayChallengeMenu() {
        System.out.println("YOU ARE IN '" + gameChoosed + "' GAME, ENJOY !");
        System.out.println("TO DO : Possibilité de choisir un type de challenge");
    }

    private void displayGoodBye() {
        System.out.println("GOOD_BYE");
        try {
            wait(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    private void displayMastermindMenu() {
        System.out.println("YOU ARE IN MASTERMIND GAME");
    }

    private void displayPlusAndMinusMenu() {
        System.out.println("YOU ARE IN PLUS AND MINUS GAME");
    }
}
