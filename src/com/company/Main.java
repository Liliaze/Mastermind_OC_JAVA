package com.company;

public class Main {

    public static void main(String[] args) {
        Menu menuGame = new Menu();

        do {
            GameState.reinitState();
            menuGame.displayWelcomeMenu();
            do {
                System.out.println("TO DO : Launch a party");
                System.out.println("TO DO : reinitParty variables");
            } while (menuGame.againSameParty());
        } while (menuGame.againChoiceGame());
        menuGame.displayGoodBye();
    }
}
