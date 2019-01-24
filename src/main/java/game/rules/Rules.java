package game.rules;
import game.GameState;
import game.constante.GameColor;
import game.constante.GameMode;
import game.constante.GameType;
import game.player.Player;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;

public abstract class Rules {

    private static final Logger myFirstLogger = LogManager.getLogger(Rules.class);

    private int nbEltInCode = 0;
    private int nbColorInCode = 0;
    private GameType gameType;
    private GameMode gameMode;

    public int getNbEltInCode() { return nbEltInCode; }
    public void setNbEltInCode(int nbEltInCode) { this.nbEltInCode = nbEltInCode; }

    public int getNbColorInCode() { return nbColorInCode; }
    public void setNbColorInCode(int nbColorInCode) { this.nbColorInCode = nbColorInCode; }

    public GameType getGameType() { return gameType; }
    public void setGameType(GameType gameType) { this.gameType = gameType; }

    public GameMode getGameMode() { return gameMode; }
    public void setGameMode(GameMode gameMode) { this.gameMode = gameMode; }


    Rules(GameType g, GameMode gm) {
        gameType = g;
        gameMode = gm;
    }

    public boolean checkEnd(int nbTurn, Player actual) {
        boolean playerVictory = false;
        boolean endOfTime = false;
        if (nbTurn >= GameState.nbTryMax) {
            endOfTime = true;
            myFirstLogger.info("\nNb turn equals max, round is over");
        }

        playerVictory = checkAttackVictory(actual);
        if (playerVictory)
            myFirstLogger.info(actual.getName() + "win the round game");
        if (!playerVictory && endOfTime  && !actual.getDefender() && actual.getEnemy().getDefender())
            GameColor.PINK.print("\nGame is over, the Defender " + actual.getEnemy().getName() + " has a very good secret code and WIN in defense !");
        else if (!playerVictory && endOfTime)
            GameColor.YELLOW.print("\nGame is over, nobody win, maybe next time ;)");
        if (endOfTime || playerVictory)
            displaySolution(actual);
        return playerVictory || endOfTime;
    }

    private void displaySolution(Player actual) {
        if (actual.getDefender())
            GameColor.PINK.print("The secret code of " + actual.getName() + " was : " + Arrays.toString(actual.getSecretCodeArray()));
        if (actual.getEnemy().getDefender())
            GameColor.PINK.print("The secret code of " + actual.getEnemy().getName() + " was : " + Arrays.toString(actual.getEnemy().getSecretCodeArray()));
    }

    public abstract boolean checkAttackVictory(Player player);

}
