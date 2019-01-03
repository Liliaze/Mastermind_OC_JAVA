package com.company;

public class Main {

    public static void main(String[] args) {
        Menu menuGame = new Menu();
        int again;

        do {
            GameState.reinitState();
            menuGame.displayWelcomeMenu();
            do {
                System.out.println("TO DO : Launch a party");
                System.out.println("TO DO : reinitParty variables");
                again = menuGame.again();
            } while (again == 1);
        } while (again == 2);
        menuGame.displayGoodBye();
    }
}
