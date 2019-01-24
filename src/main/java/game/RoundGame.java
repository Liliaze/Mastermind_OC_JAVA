package game;

import game.constante.GameColor;
import game.rules.Rules;
import game.player.Player;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class RoundGame {

    private static final Logger myFirstLogger = LogManager.getLogger(RoundGame.class);

    Player secretAgent1;
    Player secretAgent2;
    Rules rules;
    int nbTrying;

    public RoundGame(Player one, Player two, Rules rls) {
        if (one == null || two == null || rls == null) {
            myFirstLogger.error("One element of roundGame is null --> exit");
            Menu.displayGoodBye();
            return;
        }
        rules = rls;
        nbTrying = 0;
        secretAgent1 = one;
        secretAgent2 = two;
        displayRoles();
        GameColor.BLUE.print("\n\n\nWELCOME IN : " + rls.getGameType());
        GameColor.BLUE.print(secretAgent1.getName() + " FIGHT " + secretAgent2.getName());
        GameColor.CYAN.print(rls.getGameType().getRulesDsc());
        GameColor.CYAN.print("Warning, your number of turn to win is limited");
        GameColor.CYAN.print("The secretCode is constituted of ",false);
        GameColor.YELLOW.print(Integer.toString(rls.getNbEltInCode()), false);
        GameColor.CYAN.print(" number until ",false);
        GameColor.YELLOW.print(Integer.toString(rls.getNbColorInCode()  + 1), false);
        GameColor.CYAN.print(" number/color max. Good luck !");
        generateCode();
        secretAgent1.setEnemy(secretAgent2);
        secretAgent2.setEnemy(secretAgent1);


    }

    public void startRound() {

        if (!secretAgent1.getAttacker() && !secretAgent2.getAttacker()) {
            myFirstLogger.error("Error one of both player must be attacker");
            Menu.displayGoodBye();
        }

        Player currentPlayer;
        Player nextPlayer;

        if (secretAgent1.getAttacker()) {
            currentPlayer = secretAgent1;
            nextPlayer = secretAgent1;
        } else {
            currentPlayer = secretAgent2;
            nextPlayer = secretAgent2;
        }

        myFirstLogger.info("A new round start game is : " + GameState.gameChoosed + " and mode is " + GameState.modeChoosed + ", first player is : " + currentPlayer.getName());
        do {
            currentPlayer = nextPlayer;
            if (nbTrying == GameState.nbTryMax - 1)
                GameColor.YELLOW.print("\nTurn = " + nbTrying + "/" + GameState.nbTryMax + " warning, this is the last : " + currentPlayer.getName());
            else {
                GameColor.PINK.print("\nTurn = ", false);
                GameColor.YELLOW.print(Integer.toString(nbTrying), false);
                GameColor.PINK.print("/" + GameState.nbTryMax + " : ", false);
                GameColor.YELLOW.print(currentPlayer.getName());
            }
            if (GameState.devMode)
                    GameColor.GREY.print("secret code is : " + Arrays.toString(currentPlayer.getEnemy().getSecretCodeArray()));
            currentPlayer.play();
            nbTrying += 1;
            if (currentPlayer.getEnemy().getAttacker()) {
                nextPlayer = currentPlayer.getEnemy();
            } else
                nextPlayer = currentPlayer;
        } while (!rules.checkEnd(nbTrying, currentPlayer));
    }

    private void displayRoles() {
        switch (rules.getGameMode()) {
            case CHALLENGER:
                secretAgent1.setAttacker(true);
                secretAgent1.setDefender(false);
                secretAgent2.setAttacker(false);
                secretAgent2.setDefender(true);
                break;
            case DEFENDER:
                secretAgent1.setAttacker(false);
                secretAgent1.setDefender(true);
                secretAgent2.setAttacker(true);
                secretAgent2.setDefender(false);
                break;
            case DUAL:
                secretAgent1.setAttacker(true);
                secretAgent1.setDefender(true);
                secretAgent2.setAttacker(true);
                secretAgent2.setDefender(true);
                break;
            case EXIT:
                Menu.displayGoodBye();
                break;
            default:
                Menu.displayGoodBye();
                break;
        }
    }

    private void generateCode() {
        if (!secretAgent1.getDefender() && !secretAgent2.getDefender()) {
            myFirstLogger.error("Error one of both player must be defender");
            Menu.displayGoodBye();
        }
        secretAgent1.generateSecretCode();
        secretAgent2.generateSecretCode();
    }
}
