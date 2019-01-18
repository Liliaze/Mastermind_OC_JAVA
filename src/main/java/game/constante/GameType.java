package game.constante;

public enum GameType {

    PLUS_AND_MINUS(1, "search with plus or minus a secret code",
            "In this mode you try to guess the secret code of the computer, for each proposal the computer will tell you in answer if each of the numbers composing the proposed code is bigger '+', smaller '-', or equal '=' than the one to find."),
    MASTERMIND(2, "find a secret combination in a minimum of shot",
            "in this mode you try to guess the secret code of the computer, for each proposal the computer will tell you in response if each of the numbers composing the proposed code is in the secret code 'present' and if it is well placed 'good place'."),
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
