package com.company;

import static com.company.gameConstante.GameColor.*;


abstract class Player {

    public int[] propositionArray = new int[GameState.nbEltInSecretCode];
    public int proposition;
    boolean iWin;
    protected Rules rules;
    String name;

    Player(Rules r, String nameTmp) {
        rules = r;
        iWin = false;
        this.name = nameTmp;
        System.out.println("new player is create");
    }

    public abstract int[] generateSecretCode();
    public abstract boolean win();

    public void setProposition(int nb) {
        this.proposition = nb;
        for (int i = propositionArray.length - 1; i >= 0 ; i--) {
            propositionArray[i] = nb % 10;
            nb = nb /10;
        }
        System.out.println("set proposition is in int = " + proposition + " et array = " + propositionArray.toString());
    }
    public abstract void play();
}
