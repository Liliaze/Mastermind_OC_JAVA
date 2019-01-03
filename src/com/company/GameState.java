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

    private GameState() {
        gameChoosed = GameType.EXIT;
        modeChoosed = GameMode.EXIT;
    }
    public static void reinitState() {
        gameChoosed = GameType.EXIT;
        modeChoosed = GameMode.EXIT;
    }
}
