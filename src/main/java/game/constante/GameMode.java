package game.constante;

public enum GameMode {

    CHALLENGER(1, "human vs IA, find her secret code"),
    DEFENDER(2, "human vs IA, choose an secret code and cross fingers"),
    DUAL(3, "human vs IA, each in turn, try to find the code of the other"),
    EXIT(4, "to quit the Boudy Game");

    private final int modeNumber;
    private final String description;

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
