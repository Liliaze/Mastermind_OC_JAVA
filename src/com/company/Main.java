package com.company;

public class Main {

    public static void main(String[] args) {
        Menu menuGame = new Menu();
        boolean again = true;

        while (again) {
            menuGame.displayWelcomeMenu();
            again = menuGame.again();
        }
        menuGame.displayGoodBye();
    }
}
