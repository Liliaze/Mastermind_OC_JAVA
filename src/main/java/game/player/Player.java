package game.player;

import game.GameState;
import game.Menu;
import game.rules.Rules;
import game.constante.GameColor;


public abstract class Player {

    public int[] propositionArray;
    public String proposition = "";
    boolean iWin;
    protected Rules rules;
    public String name;
    public String previousReponse = "";

    Player(Rules r, String nameTmp) {
        rules = r;
        iWin = false;
        this.name = nameTmp;
        this.propositionArray = new int[r.nbEltInCode];
        System.out.println("new game.player is create");
    }

    public abstract int[] generateSecretCode();
    public abstract boolean win();

    public void setProposition(String str) {
        this.proposition = str;
        for (int i = 0; i < rules.nbEltInCode; i++) {
            propositionArray[i] = Character.getNumericValue(str.charAt(i));
        }
    }

    protected boolean checkSecretCodeFormatFromString(String str) {
        if (str.equals("exit") || str.equals("q"))
            Menu.displayGoodBye();
        if (str.length() != rules.nbEltInCode) {
            GameColor.RED.print("wrong 2format, please enter exactly" + rules.nbEltInCode + " nombre");
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            int value = Character.getNumericValue(str.charAt(i));
            System.out.println("value = " + value);
            if (value > 9 || value < 0) {
                GameColor.RED.print("wrong format, not a number : " + str.charAt(i));
                return false;
            }
            if (value > rules.nbColorInCode) {
                GameColor.RED.print("wrong format, this nb/color : " + str.charAt(i) + " is not in rules");
                return false;
            }
        }
        return true;
    }
    public abstract void play();
}
