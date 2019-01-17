package game;

import game.constante.GameType;
import game.constante.GameMode;

public class GameState {
    private static GameState ourInstance = new GameState();

    public static GameState getInstance() {
        return ourInstance;
    }

    public static GameType gameChoosed;
    public static GameMode modeChoosed;
    public static int nbEltInSecretCodeMastermind;
    public static int nbEltInSecretCodePlusOrMinus;
    public static int nbColorInSecretCodeMastermind;
    public static int nbTryMax;
    public static boolean devMode;

    private GameState() {
        gameChoosed = GameType.EXIT;
        modeChoosed = GameMode.EXIT;
        nbEltInSecretCodePlusOrMinus = 4; // tmp
        nbEltInSecretCodeMastermind = 4; //tmp before extern config
        nbColorInSecretCodeMastermind = 5; // tmp WARNING NO MORE 10 OR LESS 4 - Faire - 1 au nombre donnée car commence à 0 dans le code
        nbTryMax = 10; //tmp before extern config
        devMode = true; //tmp before extern config
    }

    public static void reinitAllGameState() {
        gameChoosed = GameType.EXIT;
        modeChoosed = GameMode.EXIT;
    }
/*
    public static void reinitParty() {
        System.out.println("TO ENHANCE : reinitParty variables");
        nbTryMax = 10; //tmp before extern config
    }*/

}
