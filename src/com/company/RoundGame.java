package com.company;

import com.company.gameConstante.GameType;
import static com.company.gameConstante.GameColor.*;

public class RoundGame {

    Player secretAgent1;
    Player secretAgent2;
    Player masterGame;
    Rules rules;
    int nbTrying;

    RoundGame(Player one, Player two, Player defender, Rules rls) {
        this.secretAgent1 = one;
        this.secretAgent2 = two;
        this.masterGame = defender;
        //GameState.setSecretCodeArray(this.secretAgent1.generateSecretCode()); // tmp test human
        GameState.setSecretCodeArray(this.masterGame.generateSecretCode());
        this.rules = rls;
        this.nbTrying = 0;
        System.out.println("A new game Start :" + GameState.gameChoosed + " in mode " + GameState.modeChoosed + " , ENJOY !");
    }


    public void startRound() {
        do {
            System.out.println("tour = " + nbTrying);
            secretAgent1.play();
            nbTrying += 1;
        } while (!rules.checkEnd(nbTrying, secretAgent1, secretAgent2, masterGame));
    }
}
