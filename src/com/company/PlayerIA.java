package com.company;

import java.util.Random;

public class PlayerIA extends Player {

    PlayerIA(Rules r, String nameTmp) {
        super(r, nameTmp);
        System.out.println("a new IA is coming, his name is : " + name);
    }

    @Override
    public int[] generateSecretCode() {
        Random rand = new Random();
        int tmpSecretCode[] = new int[GameState.nbEltInSecretCode];
        System.out.println("IA : mon code secret est :");
        for (int i = 0; i < GameState.nbEltInSecretCode; i++) {
            tmpSecretCode[i] = rand.nextInt(10);
            System.out.println(tmpSecretCode[i]);
        }
        return tmpSecretCode;
    }

    @Override
    public boolean win() {
        iWin = true;
        System.out.println("IA called " + this.name + " WIN !!!!!");
        return iWin;
    }

    @Override
    public void play() {
        System.out.println("TO DO : implement IA play turn");
    }
}
