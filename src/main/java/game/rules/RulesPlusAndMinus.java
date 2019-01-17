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
    }

    public boolean checkAttackVictory(Player player) {
        if (player == null)
            return false;
        int nbEqualityFinded = 0;
        player.previousResponse = "";

        if ( nbEltInCode != player.propositionArray.length)
            GameColor.RED.print("WARNING !!!! bug dans le nombre d'élément, fix this bug", true);

        System.out.print("Proposition : " + player.proposition + " -> Réponse : ");

        for (int i = 0 ; i < player.propositionArray.length ; i++) {
            if (player.propositionArray[i] < player.getEnemy().secretCodeArray[i]) {
                player.previousResponse += "+";
            } else if (player.propositionArray[i] == player.getEnemy().secretCodeArray[i]) {
                player.previousResponse += "=";
                nbEqualityFinded += 1;
            } else {
                player.previousResponse += "-";
            }
        }
        GameColor.PINK.print(player.previousResponse, true);
        if (nbEqualityFinded == nbEltInCode)
            return player.winInAttack();
        return false;
    }
}
