package com.company.gameConstante;

import java.util.Arrays;

public enum GameType {

    NONE(0),
    PLUS_AND_MINUS(1),
    MASTERMIND(2),
    EXIT(3);

    private int gameNumber;

    GameType(int nb) {
        this.gameNumber = nb;
    }

    public int getGameNumber() {
        return this.gameNumber;
    }

    public static GameType convertFromInt(int nb) {
        for (GameType t : GameType.values()) {
            if (t.getGameNumber() == nb)
                return t;
        }
        return null;
    }
}
