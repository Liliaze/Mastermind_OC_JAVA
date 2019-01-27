import game.Game;
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

public class Main {

    private static Logger myFirstLogger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        final Menu menuGame = new Menu();
        int again;

        DOMConfigurator.configure("src/main/resources/log4j.xml");

        //check if the devMode is precise in argument of programme
        if (args.length == 1){
            if (args[0].equals("true") || args[0].equals("false")){
                GameState.devMode = Boolean.parseBoolean(args[0]);
            }
            else {
                myFirstLogger.error("bad value in argv");
                GameColor.RED.print("bad value in argv");
                Menu.displayGoodBye();
            }
        }

        //Title of the game for welcome
        for (int i = 0; i < 50; ++i) System.out.println();
        GameColor.CYAN.print(
                "_  _ ____ ____ ___ ____ ____     ____ ____ ____ ____ ____ _  _  \n" +
                        "|\\/| |__| [__   |  |___ |__/     [__  |___ |__| |__/ |    |__|  \n" +
                        "|  | |  | ___]  |  |___ |  \\ ___ ___] |___ |  | |  \\ |___ |  |  \n" +
                        "                                                                \n" +
                        "____    ___  ____ _  _ ___  _   _ . ____    ____ ____ _  _ ____ \n" +
                        "|__|    |__] |  | |  | |  \\  \\_/  ' [__     | __ |__| |\\/| |___ \n" +
                        "|  |    |__] |__| |__| |__/   |     ___]    |__] |  | |  | |___ \n");

        //main game loop
        try {
            do {
                menuGame.displayWelcomeMenu();
                do {
                    new Game();
                    again = menuGame.again();
                } while (again == 1);
                GameState.reinitAllGameState();
            } while (again == 2);
        }
        catch (Exception e){
            GameColor.RED.print("Sorry, one error is encounter, please consult the logs, we need quit the game");
            myFirstLogger.error(e);
        }

        //before quit the game
        menuGame.displayGoodBye();
    }
}
