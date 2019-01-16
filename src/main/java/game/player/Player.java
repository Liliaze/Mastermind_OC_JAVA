package game.player;

import game.GameState;
import game.rules.Rules;
import game.constante.GameColor;


public abstract class Player {

    public int[] propositionArray = new int[GameState.nbEltInSecretCode];
    public String proposition= "";
    boolean iWin;
    protected Rules rules;
    public String name;
    public String previousReponse = "";

    Player(Rules r, String nameTmp) {
        rules = r;
        iWin = false;
        this.name = nameTmp;
        System.out.println("new game.player is create");
    }

    public abstract int[] generateSecretCode();
    public abstract boolean win();

    public void setProposition(String str) {
        this.proposition = str;
        /*
        for (int i = game.GameState.nbEltInSecretCode - 1; i >= 0 ; i--) {
            propositionArray[i] = nb % 10;
            nb = nb /10;
        }
        */
        for (int i = 0; i < GameState.nbEltInSecretCode; i++) {
            propositionArray[i] = Character.getNumericValue(str.charAt(i));
        }
    }

    protected boolean checkSecretCodeFormatFromString(String str) {
        if (str.length() != GameState.nbEltInSecretCode) {
            GameColor.RED.print("wrong format, please enter exactly" + GameState.nbEltInSecretCode + " nombre");
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            int value = Character.getNumericValue(str.charAt(i));
            System.out.println("value = " + value);
            if (value > 9 || value < 0) {
                GameColor.RED.print("wrong format, not a number");
                return false;
            }
        }
        return true;
    }
    public abstract void play();
}
