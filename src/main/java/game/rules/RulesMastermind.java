package game.rules;

import game.GameState;
import game.constante.GameColor;
import game.constante.GameMode;
import game.constante.GameType;
import game.player.Player;

public class RulesMastermind extends Rules {

    public RulesMastermind(GameType g, GameMode gm) {
        super(g, gm);
        setNbEltInCode(GameState.nbEltInSecretCodeMastermind);
        setNbColorInCode(GameState.nbColorInSecretCodeMastermind - 1);
        GameState.nbTryMax = GameState.nbTryMaxMastermind;
    }

    public boolean checkAttackVictory(Player player) {
        if (player == null)
            return false;
        int goodPlace = 0;
        int present = 0;

        if (getNbEltInCode() != player.getPropositionArray().length)
            GameColor.RED.print("WARNING !!!! bug dans le nombre d'élément, fix this bug", true);

        GameColor.BLACK.print("Proposal : " + player.getProposition() + " -> Response : ", false);

        for (int i = 0; i < player.getPropositionArray().length; i++) {
            if (player.getPropositionArray()[i] == player.getEnemy().getSecretCodeArray()[i])
                goodPlace += 1;
            else {
                for (int j = 0; j < player.getPropositionArray().length; j++) {
                    if (player.getPropositionArray()[i] == player.getEnemy().getSecretCodeArray()[j]) {
                        present += 1;
                        break;
                    }
                }
            }
        }
        if (goodPlace == getNbEltInCode()) {
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
