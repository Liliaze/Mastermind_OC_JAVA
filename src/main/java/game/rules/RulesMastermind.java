package game.rules;

import game.GameState;
import game.constante.GameColor;
import game.constante.GameMode;
import game.constante.GameType;
import game.player.Player;

public class RulesMastermind extends Rules {

    public RulesMastermind(GameType g, GameMode gm) {
        super(g, gm);
        nbEltInCode = GameState.nbEltInSecretCodeMastermind;
        nbColorInCode = GameState.nbColorInSecretCodeMastermind;
        GameState.nbTryMax = GameState.nbTryMaxMastermind;
    }

    public boolean checkAttackVictory(Player player) {
        if (player == null)
            return false;
        int goodPlace = 0;
        int present = 0;

        if (nbEltInCode != player.propositionArray.length)
            GameColor.RED.print("WARNING !!!! bug dans le nombre d'élément, fix this bug", true);

        GameColor.BLACK.print("Proposal : " + player.proposition + " -> Response : ", false);

        for (int i = 0; i < player.propositionArray.length; i++) {
            if (player.propositionArray[i] == player.getEnemy().secretCodeArray[i])
                goodPlace += 1;
            else {
                for (int j = 0; j < player.propositionArray.length; j++) {
                    if (player.propositionArray[i] == player.getEnemy().secretCodeArray[j]) {
                        present += 1;
                        break;
                    }
                }
            }
        }
        if (goodPlace == nbEltInCode) {
            GameColor.GREEN.print(goodPlace + " good place :D", true);
            return player.winInAttack();
        }
        if (goodPlace == 0 && present == 0)
            GameColor.PINK.print("Missing, nothing...", false);
        if (present > 0) {
            GameColor.YELLOW.print(present > 1 ? present + " presents" : present + " present", false);
            if (goodPlace > 0)
                GameColor.DEFAULT.print(", ", false);
        }
        if (goodPlace > 0)
            GameColor.GREEN.print(goodPlace > 1 ? goodPlace + " goods places" : goodPlace + " good place", false);
        System.out.print("\n");
        return false;
    }

}
