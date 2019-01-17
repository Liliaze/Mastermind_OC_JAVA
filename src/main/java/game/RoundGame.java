package game;

import game.constante.GameColor;
import game.constante.GameMode;
import game.rules.Rules;
import game.player.Player;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class RoundGame {

    private static Logger myFirstLogger = LogManager.getLogger(RoundGame.class);
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
        generateCode();
        secretAgent1.setEnemy(secretAgent2);
        secretAgent2.setEnemy(secretAgent1);

        GameColor.BLUE.print("WELCOME IN : " + rls.gameType);
        GameColor.BLUE.print(secretAgent1.name + " FIGHT " + secretAgent2.name);
        GameColor.CYAN.print(rls.gameType.getRulesDsc());
        GameColor.CYAN.print("The secretCode is constituted of " + rls.nbEltInCode + " number/color. Good luck !");
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

        myFirstLogger.info("A new round start game is : " + GameState.gameChoosed + " and mode is " + GameState.modeChoosed + ", first player is : " + currentPlayer.name);
        do {
            currentPlayer = nextPlayer;
            if (nbTrying == GameState.nbTryMax - 1)
                GameColor.YELLOW.print("Tour = " + nbTrying + "/" + GameState.nbTryMax + " warning, this is the last : " + currentPlayer.name);
            else
                GameColor.PINK.print("Tour = " + nbTrying + "/" + GameState.nbTryMax + " : " + currentPlayer.name);
            currentPlayer.play();
            nbTrying += 1;
            if (currentPlayer.getEnemy().getAttacker()) {
                nextPlayer = currentPlayer.getEnemy();
            } else
                nextPlayer = currentPlayer;
        } while (!rules.checkEnd(nbTrying, currentPlayer));
    }

    private void displayRoles() {
        switch (rules.gameMode) {
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
            myFirstLogger.error("Error one of both player mus be defender");
            Menu.displayGoodBye();
        }
        secretAgent1.generateSecretCode();
        secretAgent2.generateSecretCode();
    }
}
