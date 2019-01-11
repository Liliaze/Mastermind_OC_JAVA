package com.company;

import com.company.gameConstante.GameType;

import static com.company.gameConstante.GameColor.*;

import java.util.Random;

public class PlayerIA extends Player {
    private boolean firstTry = true;
    private boolean secondTry = true;

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
        BLUE.print("IA called " + this.name + " WIN !!!!!");
        return iWin;
    }

    @Override
    public void play() {
        System.out.println("TO DO : implement IA play turn");
        if (GameState.gameChoosed == GameType.MASTERMIND)
            playMastermind();
        else
            playPlusOrMinus();
    }

    private void playPlusOrMinus() {
        System.out.println("TO DO : play for plusAndMinus");
        String iaProposition = "";
        if (firstTry) {
            firstTry = false;
            for (int i = 0; i < GameState.nbEltInSecretCode; i++) {
                iaProposition += "5";
            }
            setProposition(iaProposition);
            return;
        }
        if (secondTry) {
            secondTry = false;
        for (int i = 0; i < GameState.nbEltInSecretCode; i++) {
            if (previousReponse.charAt(i) == '+') {
                iaProposition += "7"; //Integer.toString(propositionArray[i] + ((10 - propositionArray[i]) / 2));
            } else if (previousReponse.charAt(i) == '-') {
                iaProposition += "2" ;//Integer.toString(propositionArray[i] - ((10 - propositionArray[i]) / 2));
            } else
                iaProposition += Integer.toString(propositionArray[i]);
        }
        setProposition(iaProposition);
           return;
    }
        for (int i = 0; i < GameState.nbEltInSecretCode; i++) {
            if (previousReponse.charAt(i) == '+') {
                iaProposition += Integer.toString(propositionArray[i] + 1);
            } else if (previousReponse.charAt(i) == '-') {
                iaProposition += Integer.toString(propositionArray[i] - 1);
            } else
                iaProposition += Integer.toString(propositionArray[i]);
        }
        setProposition(iaProposition);
        // test to good solution immediate :
        // setProposition(Integer.toString(GameState.secretCodeInt));
    }

    private void playMastermind() {
        System.out.println("TO DO : play for Mastermind");
        setProposition(Integer.toString(GameState.secretCodeInt));
    }
}
