package com.company.gameConstante;

public enum GameChallenge {

    PLUS_AND_MINUS(1),
    MASTERMIND(2);

    private int gameNumber;

    GameChallenge(int nb) {
        this.gameNumber = nb;
    }

    public int getGameNumber() {
        return this.gameNumber;
    }

    public static GameChallenge convertFromInt(int nb) {
        for (GameChallenge t : GameChallenge.values()) {
            if (t.getGameNumber() == nb)
                return t;
        }
        return null;
    }
}
