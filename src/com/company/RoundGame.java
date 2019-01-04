package com.company;

import com.company.gameConstante.GameType;

public class RoundGame {

    Player secretAgent1;
    Player secretAgent2;
    Player masterGame;
    Rules rules;

    RoundGame(Player one, Player two, Player defender, Rules rls) {
        this.secretAgent1 = one;
        this.secretAgent2 = two;
        this.masterGame = defender;
        this.rules = rls;
        System.out.println("A new game Start :" + GameState.gameChoosed + " in mode " + GameState.modeChoosed + " , ENJOY !");
    }

    public void test() {
        System.out.println("test");
    }
}
