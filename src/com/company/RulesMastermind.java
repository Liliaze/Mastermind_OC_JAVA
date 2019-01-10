package com.company;

import static com.company.gameConstante.GameColor.*;

public class RulesMastermind extends Rules {

    RulesMastermind() {
        System.out.println("This game is under Mastermind Rules");
    }
/*
    public boolean checkVictory(Player player) {
        if (player == null)
            return false;
        System.out.println("!!!!!!! TEST TMP A REVOIR CPMLTMT !!!!! ");
        int nbGood = 0;
        int nbBadPlace = 0;
        for (int i = 0; i < GameState.nbEltInSecretCode; i++) {
            if (player.propositionArray[i] < GameState.secretCodeArray[i]) {
                System.out.println("c'est moins");
            } else if (player.propositionArray[i] == GameState.secretCodeArray[i]) {
                System.out.println("c'est bon");
                nbGood += 1;
            } else {
                nbBadPlace += 1;
                System.out.println("c'est sup");
            }
        }
        if (nbGood == GameState.nbEltInSecretCode)
            return player.win();
        return false;
    }
*/
    public boolean checkVictory(Player player) {
        if (player == null)
            return false;
        int goodPlace = 0;
        int present = 0;

        if (GameState.nbEltInSecretCode != player.propositionArray.length)
            RED.print("WARNING !!!! bug dans le nombre d'élément, fix this bug", true);

        System.out.print("Proposition : " + player.proposition + " -> Réponse : ");

        for (int i = 0; i < player.propositionArray.length; i++) {
            if (player.propositionArray[i] == GameState.secretCodeArray[i])
                goodPlace += 1;
            else {
                for (int j = 0; j < player.propositionArray.length; j++) {
                    if (player.propositionArray[i] == GameState.secretCodeArray[j]) {
                        present += 1;
                        break;
                    }
                }
            }
        }
        if (goodPlace == GameState.nbEltInSecretCode)
            return player.win();
        if (goodPlace == 0 && present == 0)
            PINK.print("Vous êtes à côté de la plaque", false);
        else if (present > 0) {
            YELLOW.print(present > 1 ? present + " présents" : present + " présent", false);
            if (goodPlace > 0)
                DEFAULT.print(", ", false);
        }
        if (goodPlace > 0)
            GREEN.print(goodPlace > 1 ? goodPlace + " bien placés" : goodPlace + " bien placé", false);
        System.out.print("\n");
        return false;
    }

}
