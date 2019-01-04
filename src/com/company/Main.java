package com.company;

public class Main {

    private static void launchARoundGame(Menu menu) {
        switch (GameState.gameChoosed) {
            case PLUS_AND_MINUS:
                System.out.println("TO DO : implement Plus and Minus Rules");
                switch (GameState.modeChoosed) {
                    case CHALLENGER:
                        System.out.println("TO DO : implement challenger");
                        RoundGame newRound = new RoundGame(new PlayerHuman(), null, new PlayerIA(), new RulesPlusAndMinus());
                        newRound.test();
                        break;
                    case DEFENDER:
                        System.out.println("TO DO : implement defender");
                        break;
                    case DUAL:
                        System.out.println("TO DO : implement DUAL");
                        break;
                    case EXIT:
                        menu.displayGoodBye();
                        break;
                    default:
                        menu.displayGoodBye();
                        break;
                }
                break;
            case MASTERMIND:
                System.out.println("TO DO : implement Mastermind Rules");
                switch (GameState.modeChoosed) {
                    case CHALLENGER:
                        System.out.println("TO DO : implement challenger");
                        break;
                    case DEFENDER:
                        System.out.println("TO DO : implement defender");
                        break;
                    case DUAL:
                        System.out.println("TO DO : implement DUAL");
                        break;
                    case EXIT:
                        menu.displayGoodBye();
                        break;
                    default:
                        menu.displayGoodBye();
                        break;
                }
                break;
            case EXIT:
                menu.displayGoodBye();
                break;
            default:
                menu.displayGoodBye();
                break;
        }
    }

    public static void main(String[] args) {
        Menu menuGame = new Menu();
        int again;

        do {
            menuGame.displayWelcomeMenu();
            do {
                launchARoundGame(menuGame);
                again = menuGame.again();
                GameState.reinitParty();
            } while (again == 1);
            GameState.reinitAllGameState();
        } while (again == 2);
        menuGame.displayGoodBye();
    }
}
