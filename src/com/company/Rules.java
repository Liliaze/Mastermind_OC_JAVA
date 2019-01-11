package com.company;
import static com.company.gameConstante.GameColor.*;

abstract class Rules {

    Rules() {
        System.out.println("new Rules is create");
    }


    public boolean checkEnd(int nbTurn, Player secretAgent1, Player secretAgent2, Player masterGame) {
        boolean playerVictory = false;
        if (checkVictory(secretAgent1))
            playerVictory = true;
        if (checkVictory(secretAgent2))
        {
            if (playerVictory)
                GREEN.print("BOTH PLAYER WINS : " + secretAgent1.name + " and " + secretAgent2.name + " ==> 'EQUALITY', CONGRATULATION ! ! !");
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
