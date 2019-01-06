package com.company;

import com.company.gameConstante.GameType;
import com.company.gameConstante.GameMode;

public class GameState {
    private static GameState ourInstance = new GameState();

    public static GameState getInstance() {
        return ourInstance;
    }

    public static GameType gameChoosed;
    public static GameMode modeChoosed;
    public static int nbEltInSecretCode = 4; //tmp before extern config
    public static int nbTryMax;
    public static int[] secretCodeArray;
    public static int   secretCodeInt;//tmp before extern config

    private GameState() {
        gameChoosed = GameType.EXIT;
        modeChoosed = GameMode.EXIT;
        nbTryMax = 10; //tmp before extern config
    }

    public static void setSecretCodeArray(int[] secretCodeA) {
        GameState.secretCodeArray = secretCodeA;
        GameState.secretCodeInt = GameState.arrayToInt(secretCodeA);
    }

    public static void reinitAllGameState() {
        gameChoosed = GameType.EXIT;
        modeChoosed = GameMode.EXIT;
        nbTryMax = 10; //tmp before extern config
    }

    public static void reinitParty() {
        System.out.println("TO ENHANCE : reinitParty variables");
        nbTryMax = 10; //tmp before extern config
    }
    public static int arrayToInt(int[] array) {
        int nb = 0;
        for (int i = 0; i < array.length ; i++){
            nb = nb * 10 + array[i];
        }
        System.out.println("code secret to int = " + nb);
        return nb;
    }
}
