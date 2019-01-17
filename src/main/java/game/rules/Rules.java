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
            myFirstLogger.info("Nb turn equals max, round is over");
        }

        if (checkAttackVictory(actual)) {
            playerVictory = true;
            if (endOfTime) {
                GameColor.PINK.print("But time is out, so " + actual.getEnemy().name + " WIN TOO IN DEFENSE");
                GameColor.GREEN.print("BOTH PLAYER WINS : " + actual.name + " and " + actual.getEnemy().name + " ==> 'EQUALITY', CONGRATULATION ! ! !");
            }
        }
        if (!playerVictory && endOfTime)
            GameColor.YELLOW.print("Game is over, nobody win, maybe next time ;)");

        /*
        if (checkAttackVictory(secretAgent2))
        {
            playerVictory = true;
            if (endOfTime) {
                GameColor.PINK.print("But time is out, so " + secretAgent1.name + " WIN TOO IN DEFENSE");
            }
            if (playerVictory && endOfTime) {
                GameColor.GREEN.print("BOTH PLAYER WINS IN ATTACK AND IN DEFENSE : " + secretAgent1.name + " and " + secretAgent2.name + " ==> ' PERFECT EQUALITY', CONGRATULATION ! ! !");
            }
            else if (playerVictory) {
                GameColor.GREEN.print("BOTH PLAYER WINS IN ATTACK: " + secretAgent1.name + " and " + secretAgent2.name + " ==> 'EQUALITY', CONGRATULATION ! ! !");
            }
        }
*/
        return playerVictory || endOfTime;
    }

    public abstract boolean checkAttackVictory(Player player);

}
