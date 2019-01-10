package com.company;
import static com.company.gameConstante.GameColor.*;

abstract class Rules {

    Rules() {
        System.out.println("new Rules is create");
    }


    public boolean checkEnd(int nbTurn, Player secretAgent1, Player secretAgent2, Player masterGame) {
        if (checkVictory(secretAgent1) || checkVictory(secretAgent2)) {
            return true;
        }
        else if (nbTurn >= GameState.nbTryMax) {
            System.out.println("Le nombre d'essai imparti est écoulé, la partie est finie");
            return masterGame.win();
        }
        return false;
    }
    public abstract boolean checkVictory(Player player);

}
