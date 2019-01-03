package com.company.gameConstante;

public enum GameMode {

    NONE(0),
    CHALLENGER(1),
    DEFENDER(2),
    DUAL(3);

    private int modeNumber;

    GameMode(int nb) {
        this.modeNumber = nb;
    }

    public int getModeNumber() {
        return this.modeNumber;
    }

    public static GameMode convertFromInt(int nb) {
        for (GameMode t : GameMode.values()) {
            if (t.getModeNumber() == nb)
                return t;
        }
        return null;
    }
}
