package game.player;

import game.Menu;
import game.rules.Rules;
import game.constante.GameColor;


public abstract class Player {
    private Rules rules;
    private Player enemy;
    private String name;

    private int[] secretCodeArray;
    private int[] propositionArray;
    private String proposition = "";
    private String previousResponse = "";





    private boolean defender;
    private boolean attacker;
    private boolean iWin;


    public Rules getRules() { return rules; }
    public Player getEnemy() { return enemy; }
    public String getName() { return name; }
    public int[] getSecretCodeArray() {  return secretCodeArray; }
    public int[] getPropositionArray() { return propositionArray; }
    public String getProposition() { return proposition; }
    public boolean isDefender() { return defender;}
    public boolean isAttacker() { return attacker; }
    public boolean getDefender() { return defender; }
    public boolean getAttacker() { return attacker; }
    public boolean isiWin() { return iWin; }
    public String getPreviousResponse() { return previousResponse; }


    public void setRules(Rules rules) { this.rules = rules; }
    public void setEnemy(Player en) { enemy = en; }
    public void setName(String name) { this.name = name; }
    public void setSecretCodeArray(int[] secretCodeArray) { this.secretCodeArray = secretCodeArray; }
    public void setDefender(boolean defender) { this.defender = defender; }
    public void setAttacker(boolean attacker) { this.attacker = attacker; }
    public void setDefender(Boolean val) { defender = val; }
    public void setAttacker(Boolean val) { attacker = val; }
    public void setiWin(boolean iWin) { this.iWin = iWin; }
    public void setPreviousResponse(String previousResponse) { this.previousResponse = previousResponse; }

    Player(Rules r, String nameTmp, Player en) {
        setRules(r);
        setiWin(false);
        setName(nameTmp);
        setEnemy(en);
        propositionArray = new int[r.getNbEltInCode()];
        secretCodeArray = new int[r.getNbEltInCode()];
    }

    public abstract void generateSecretCode();
    public abstract void play();
    public abstract boolean winInAttack();


    public void setProposition(String str) {
        this.proposition = str;
        for (int i = 0; i < rules.getNbEltInCode(); i++) {
            propositionArray[i] = Character.getNumericValue(str.charAt(i));
        }
    }

    protected boolean checkSecretCodeFormatFromString(String str) {
        if (str.equals("exit") || str.equals("q"))
            Menu.displayGoodBye();
        if (str.length() != rules.getNbEltInCode()) {
            GameColor.RED.print("wrong format, please enter exactly " + rules.getNbEltInCode() + " number");
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            int value = Character.getNumericValue(str.charAt(i));
            if (value > 9 || value < 0) {
                GameColor.RED.print("wrong format, not a number : " + str.charAt(i));
                return false;
            }
            if (value > rules.getNbColorInCode()) {
                GameColor.RED.print("wrong format, this nb/color : " + str.charAt(i) + " is not in rules");
                return false;
            }
        }
        return true;
    }

}
