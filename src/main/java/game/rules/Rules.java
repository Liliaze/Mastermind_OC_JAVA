package game.rules;
import game.GameState;
import game.constante.GameColor;
import game.constante.GameType;
import game.player.Player;

public abstract class Rules {

    public int nbEltInCode = 0;
    public int nbColorInCode = 0;
    public GameType gameType;

    Rules(GameType g) {
        gameType = g;
    }


    public boolean checkEnd(int nbTurn, Player secretAgent1, Player secretAgent2, Player masterGame) {
        boolean playerVictory = false;
        if (checkVictory(secretAgent1))
            playerVictory = true;
        if (checkVictory(secretAgent2))
        {
            if (playerVictory)
                GameColor.GREEN.print("BOTH PLAYER WINS : " + secretAgent1.name + " and " + secretAgent2.name + " ==> 'EQUALITY', CONGRATULATION ! ! !");
            playerVictory = true;
        }
        else if (nbTurn >= GameState.nbTryMax) {
            System.out.println("Le nombre d'essai imparti est écoulé, la partie est finie");
            return masterGame.win();
        }
        return playerVictory;
    }
    public abstract boolean checkVictory(Player player);

}
