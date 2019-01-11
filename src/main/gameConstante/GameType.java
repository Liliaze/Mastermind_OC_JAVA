package main.gameConstante;

public enum GameType {

    PLUS_AND_MINUS(1, "\033[31m le plus et le mooins en couleur\033[0m"),
    MASTERMIND(2, "to do desc"),
    EXIT(3, "to quit this Boudy Game's");

    private int gameNumber;
    private String description;

    GameType(int nb, String desc) {
        this.gameNumber = nb;
        this.description = desc;
    }

    public int getNumber() {
        return this.gameNumber;
    }
    public String getDescription() { return this.description;}

    public static GameType convertFromInt(int nb) {
        for (GameType t : GameType.values()) {
            if (t.getNumber() == nb)
                return t;
        }
        return null;
    }
}
