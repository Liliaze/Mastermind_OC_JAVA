package game;

import game.player.Human;
import game.player.IA;
import game.rules.Rules;
import game.rules.RulesMastermind;
import game.rules.RulesPlusAndMinus;

public class Game {

    public Game(){
        launchARoundGame();
    }

    private static void launchARoundGame() {
        Rules rules = null;
        switch (GameState.gameChoosed) {
            case PLUS_AND_MINUS:
                rules = new RulesPlusAndMinus(GameState.gameChoosed, GameState.modeChoosed);
                break;
            case MASTERMIND:
                rules = new RulesMastermind(GameState.gameChoosed, GameState.modeChoosed);
                break;
            case EXIT:
                Menu.displayGoodBye();
                break;
            default:
                Menu.displayGoodBye();
                break;
        }

        RoundGame newRound = new RoundGame(new Human(rules, GameState.playerName, null), new IA(rules, "JEANNETTE", null), rules);
        newRound.startRound();
    }

}
