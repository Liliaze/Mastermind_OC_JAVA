package com.company;

public class RulesMastermind extends Rules {

    RulesMastermind() {
        System.out.println("This game is under Mastermind Rules");
    }

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



}
