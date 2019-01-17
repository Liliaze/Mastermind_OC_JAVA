package game.rules;
import game.GameState;
import game.constante.GameColor;
import game.constante.GameType;
import game.player.Player;

public class RulesPlusAndMinus extends Rules {

    public RulesPlusAndMinus(GameType g) {
        super(g);
        nbEltInCode = GameState.nbEltInSecretCodePlusOrMinus;
        nbColorInCode = 9;
    }

    public boolean checkVictory(Player player) {
        if (player == null)
            return false;
        int nbEqualityFinded = 0;
        player.previousReponse = "";

        if ( nbEltInCode != player.propositionArray.length)
            GameColor.RED.print("WARNING !!!! bug dans le nombre d'élément, fix this bug", true);

        System.out.print("Proposition : " + player.proposition + " -> Réponse : ");

        for (int i = 0 ; i < player.propositionArray.length ; i++) {
            if (player.propositionArray[i] < GameState.secretCodeArray[i]) {
                player.previousReponse += "+";
            } else if (player.propositionArray[i] == GameState.secretCodeArray[i]) {
                player.previousReponse += "=";
                nbEqualityFinded += 1;
            } else {
                player.previousReponse += "-";
            }
        }
        GameColor.PINK.print(player.previousReponse, true);
        if (nbEqualityFinded == nbEltInCode)
            return player.win();
        return false;
    }
}
