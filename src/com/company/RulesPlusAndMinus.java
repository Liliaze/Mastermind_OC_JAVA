package com.company;
import static com.company.gameConstante.GameColor.*;

public class RulesPlusAndMinus extends Rules {

    RulesPlusAndMinus() {
        System.out.println("This game is under Plus and Minus Rules");
    }

    public boolean checkVictory(Player player) {
        if (player == null)
            return false;
        int nbEqualityFinded = 0;

        if ( GameState.nbEltInSecretCode != player.propositionArray.length)
            RED.print("WARNING !!!! bug dans le nombre d'élément, fix this bug", true);

        System.out.print("Proposition : " + player.proposition + " -> Réponse : ");

        for (int i = 0 ; i < player.propositionArray.length ; i++) {
            if (player.propositionArray[i] < GameState.secretCodeArray[i]) {
                PINK.print("+", false);
            } else if (player.propositionArray[i] == GameState.secretCodeArray[i]) {
                GREEN.print("=", false);
                nbEqualityFinded += 1;
            } else
                PINK.print("-", false);
        }
        System.out.print("\n");
        if (nbEqualityFinded == GameState.nbEltInSecretCode)
            return player.win();
        return false;
    }
}
