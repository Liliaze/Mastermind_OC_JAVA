import game.GameState;
import game.Menu;
import game.RoundGame;
import game.constante.GameColor;
import game.rules.Rules;
import game.rules.RulesMastermind;
import game.rules.RulesPlusAndMinus;
import game.player.Human;
import game.player.IA;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.IOException;

public class Main {

    private static Logger myFirstLogger = LogManager.getLogger(Main.class);

    private static void launchARoundGame(Menu menu) {
        Rules rules = null;
        switch (GameState.gameChoosed) {
            case PLUS_AND_MINUS:
                rules = new RulesPlusAndMinus(GameState.gameChoosed, GameState.modeChoosed);
                break;
            case MASTERMIND:
                rules = new RulesMastermind(GameState.gameChoosed, GameState.modeChoosed);
                break;
            case EXIT:
                menu.displayGoodBye();
                break;
            default:
                menu.displayGoodBye();
                break;
        }

        RoundGame newRound = null;
        newRound = new RoundGame(new Human(rules, GameState.playerName, null), new IA(rules, "JEANNETTE", null), rules);
        newRound.startRound();
    }

    public static void main(String[] args) {
        Menu menuGame = new Menu();
        int again;

        DOMConfigurator.configure("src/main/resources/log4j.xml");

        for (int i = 0; i < 50; ++i) System.out.println();
        GameColor.CYAN.print(
                "_  _ ____ ____ ___ ____ ____     ____ ____ ____ ____ ____ _  _  \n" +
                "|\\/| |__| [__   |  |___ |__/     [__  |___ |__| |__/ |    |__|  \n" +
                "|  | |  | ___]  |  |___ |  \\ ___ ___] |___ |  | |  \\ |___ |  |  \n" +
                "                                                                \n" +
                "____    ___  ____ _  _ ___  _   _ . ____    ____ ____ _  _ ____ \n" +
                "|__|    |__] |  | |  | |  \\  \\_/  ' [__     | __ |__| |\\/| |___ \n" +
                "|  |    |__] |__| |__| |__/   |     ___]    |__] |  | |  | |___ \n");

        do {
            menuGame.displayWelcomeMenu();
            do {
                launchARoundGame(menuGame);
                again = menuGame.again();
            } while (again == 1);
            GameState.reinitAllGameState();
        } while (again == 2);
        menuGame.displayGoodBye();
    }
}
