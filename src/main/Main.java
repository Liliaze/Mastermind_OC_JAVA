package main;

import main.Rules.Rules;
import main.Rules.RulesMastermind;
import main.Rules.RulesPlusAndMinus;
import main.player.Human;
import main.player.IA;

public class Main {

    private static void launchARoundGame(Menu menu) {
        Rules rules = null;
        switch (GameState.gameChoosed) {
            case PLUS_AND_MINUS:
                rules = new RulesPlusAndMinus();
                break;
            case MASTERMIND:
                rules = new RulesMastermind();
                break;
            case EXIT:
                menu.displayGoodBye();
                break;
            default:
                menu.displayGoodBye();
                break;
        }

        RoundGame newRound = null;
        switch (GameState.modeChoosed) {
            case CHALLENGER:
                newRound = new RoundGame(new Human(rules, "JEAN"), null, new IA(rules, "MAITRE"), rules);
                break;
            case DEFENDER:
                newRound = new RoundGame(new IA(rules, "JEANNETTE"), null, new Human(rules, "ALTHEA"), rules);
                break;
            case DUAL:
                newRound = new RoundGame(new Human(rules, "ALTHEA"), new IA(rules, "JEANNETTE"), new IA(rules, "GAMEMASTER"), rules);
                break;
            case EXIT:
                menu.displayGoodBye();
                break;
            default:
                menu.displayGoodBye();
                break;
        }
        newRound.startRound();
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
