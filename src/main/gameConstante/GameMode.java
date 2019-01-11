package main.gameConstante;

public enum GameMode {

    CHALLENGER(1, "xxxxx TO DO DS"),
    DEFENDER(2, "xxxxx TO DO DSt2"),
    DUAL(3, "xxxxx TO DO DSt3"),
    EXIT(4, "to quit the Boudy Game");

    private int modeNumber;
    private String description;

    GameMode(int nb, String desc) {
        this.modeNumber = nb;
        this.description = desc;
    }

    public int getNumber() {
        return this.modeNumber;
    }
    public String getDescription() {
        return this.description;
    }

    public static GameMode convertFromInt(int nb) {
        for (GameMode t : GameMode.values()) {
            if (t.getNumber() == nb)
                return t;
        }
        return null;
    }
}
