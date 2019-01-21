package game.rules;
import game.GameState;
import game.constante.GameColor;
import game.constante.GameMode;
import game.constante.GameType;
import game.player.Player;

public class RulesPlusAndMinus extends Rules {

    public RulesPlusAndMinus(GameType g, GameMode gm) {
        super(g, gm);
        nbEltInCode = GameState.nbEltInSecretCodePlusOrMinus;
        nbColorInCode = 9;
        GameState.nbTryMax = GameState.nbTryMaxPlusOrMinus;

    }

    public boolean checkAttackVictory(Player player) {
        if (player == null)
            return false;
        int nbEqualityFinded = 0;
        player.previousResponse = "";

        if ( nbEltInCode != player.getPropositionArray().length)
            GameColor.RED.print("WARNING !!!! bug in the number of element, fix this bug", true);

        GameColor.BLACK.print("Proposal: " + player.getProposition() + " -> Response : ", false);

        for (int i = 0; i < player.getPropositionArray().length ; i++) {
            if (player.getPropositionArray()[i] < player.getEnemy().getSecretCodeArray()[i]) {
                player.previousResponse += "+";
                GameColor.YELLOW.print("+",false);
            } else if (player.getPropositionArray()[i] == player.getEnemy().getSecretCodeArray()[i]) {
                player.previousResponse += "=";
                GameColor.GREEN.print("=",false);
                nbEqualityFinded += 1;
            } else {
                player.previousResponse += "-";
                GameColor.YELLOW.print("-",false);
            }
        }
        System.out.println();
        if (nbEqualityFinded == nbEltInCode)
            return player.winInAttack();
        return false;
    }
}
