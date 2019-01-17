package game.player;

import game.GameState;
import game.Menu;
import game.rules.Rules;
import game.constante.GameColor;


public abstract class Player {
    protected Rules rules;
    protected Player enemy;

    public int[] secretCodeArray;
    public int[] propositionArray;
    public String proposition = "";
    public String previousResponse = "";

    public String name;
    protected boolean defender;
    protected boolean attacker;
    boolean iWin;

    Player(Rules r, String nameTmp, Player en) {
        rules = r;
        iWin = false;
        name = nameTmp;
        enemy = en;
        propositionArray = new int[r.nbEltInCode];
        secretCodeArray = new int[r.nbEltInCode];
        System.out.println("new game.player is create");
    }

    public abstract void generateSecretCode();
    public abstract void play();
    public abstract boolean winInAttack();

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
            GameColor.RED.print("wrong format, please enter exactly " + rules.nbEltInCode + " number");
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            int value = Character.getNumericValue(str.charAt(i));
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

    protected int arrayToInt(int[] array) {
        int nb = 0;
        for (int i = 0; i < array.length ; i++){
            nb = nb * 10 + array[i];
        }
        return nb;
    }
    public void setEnemy(Player en) {
        enemy = en;
    }

    public Player getEnemy() {
        return enemy;
    }
    public boolean getDefender() {
        return defender;
    }
    public boolean getAttacker() {
        return attacker;
    }
    public void setDefender(Boolean val) {
        defender = val;
    }
    public void setAttacker(Boolean val) {
        attacker = val;
    }
}
