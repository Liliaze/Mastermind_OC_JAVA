package com.company;

public class Main {

    private static void launchARoundGame(Menu menu) {
        Rules rules = null;
        switch (GameState.gameChoosed) {
            case PLUS_AND_MINUS:
                rules = new RulesPlusAndMinus();
                switch (GameState.modeChoosed) {
                    case CHALLENGER:
                        RoundGame newRound = new RoundGame(new PlayerHuman(rules, "JEAN"), null, new PlayerIA(rules, "MAITRE"), rules);
                        newRound.startRound();
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
                rules = new RulesMastermind();
                switch (GameState.modeChoosed) {
                    case CHALLENGER:
                        RoundGame newRound = new RoundGame(new PlayerHuman(rules, "JEAN"), null, new PlayerIA(rules, "MAITRE"), rules);
                        newRound.startRound();
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
