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
    public static int nbTrying;
    public static int[] SecretCode = new int[] {1 ,2, 4, 8}; //tmp before extern config

    private GameState() {
        gameChoosed = GameType.EXIT;
        modeChoosed = GameMode.EXIT;
        nbTrying = 10; //tmp before extern config
    }

    public static void reinitAllGameState() {
        gameChoosed = GameType.EXIT;
        modeChoosed = GameMode.EXIT;
        nbTrying = 10; //tmp before extern config
    }

    public static void reinitParty() {
        System.out.println("TO ENHANCE : reinitParty variables");
        nbTrying = 10; //tmp before extern config
    }
}
