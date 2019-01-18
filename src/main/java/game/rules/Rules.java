package game.rules;
import game.GameState;
import game.RoundGame;
import game.constante.GameColor;
import game.constante.GameMode;
import game.constante.GameType;
import game.player.Player;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public abstract class Rules {

    private static Logger myFirstLogger = LogManager.getLogger(Rules.class);

    public int nbEltInCode = 0;
    public int nbColorInCode = 0;
    public GameType gameType;
    public GameMode gameMode;

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

        if (checkAttackVictory(actual)) {
            playerVictory = true;
            if (endOfTime) {
                GameColor.PINK.print("But time is out, so " + actual.getEnemy().name + " WIN TOO IN DEFENSE");
                GameColor.GREEN.print("BOTH PLAYER WINS : " + actual.name + " and " + actual.getEnemy().name + " ==> 'EQUALITY', CONGRATULATION ! ! !");
            }
        }
        if (!playerVictory && endOfTime  && !actual.getDefender() && actual.getEnemy().getDefender())
            GameColor.PINK.print("\nGame is over, the Defender " + actual.getEnemy().name + " has a very good secret code and WIN in defense !");
        else if (!playerVictory && endOfTime)
            GameColor.YELLOW.print("\nGame is over, nobody win, maybe next time ;)");

        return playerVictory || endOfTime;
    }

    public abstract boolean checkAttackVictory(Player player);

}
