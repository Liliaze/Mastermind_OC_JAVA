package game.constante;

public enum GameType {

    PLUS_AND_MINUS(1, "search with plus or minus a secret code", "The defender generate a code and the ..."),
    MASTERMIND(2, "find a secret combination in a minimum of shot", "The defender indicates if a number of your proposal exists in the code and if it is well placed"),
    EXIT(3, "to quit this Boudy Game's", "exit");

    private int gameNumber;
    private String description;
    private String rulesDsc;

    GameType(int nb, String desc, String rDsc) {
        this.gameNumber = nb;
        this.description = desc;
        this.rulesDsc = rDsc;
    }

    public int getNumber() {
        return this.gameNumber;
    }
    public String getDescription() { return this.description;}
    public String getRulesDsc() { return this.rulesDsc;}

    public static GameType convertFromInt(int nb) {
        for (GameType t : GameType.values()) {
            if (t.getNumber() == nb)
                return t;
        }
        return null;
    }
}
