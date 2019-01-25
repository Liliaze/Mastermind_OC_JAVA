package game.player;

import game.GameState;
import game.rules.Rules;
import game.constante.GameType;
import game.constante.GameColor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IA extends Player {
    private static final Logger myFirstLogger = LogManager.getLogger(IA.class);
    private Hashtable<Integer, Integer> validColor = new Hashtable<>();
    private List allPossibility = new LinkedList();

    private boolean firstTry = true;
    private boolean secondTry = true;
    private int checkValidColor = 0;
    private int lastBadValue = -1;

    public IA(Rules r, String nameTmp, Player en) {
        super(r, nameTmp, en);
        myFirstLogger.debug("a new IA is coming, his name is : " + getName());
        if (getRules().getGameType() == GameType.MASTERMIND) {
            generateAllPossibility();
            if (getRules().getNbColorInCode() < 10)
                lastBadValue = 9;
        }
    }

    //generate a list of possibility until biggest color
    private void generateAllPossibility() {
        String tmp;
        int nbMax = 0;
        for (int i = 0; i < getRules().getNbEltInCode(); i++) {
            nbMax = nbMax * 10 + getRules().getNbColorInCode();
        }

        for (int i = 0; i <= nbMax; i++) {
            tmp = Integer.toString(i);
            if (checkNotBadValue(tmp)) {
                while (tmp.length() < getRules().getNbEltInCode()) {
                    tmp = "0" + tmp;
                }
                allPossibility.add(tmp);
            }
        }
    }

    //in list of possibility, delete possibilities who contains a color which is not in rules
    private boolean checkNotBadValue(String nb) {
        for (int i = 0; i < nb.length(); i++) {
            if (Character.getNumericValue(nb.charAt(i)) > getRules().getNbColorInCode()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void generateSecretCode() {
        Random rand = new Random();
        GameColor.YELLOW.print(getName() + " type IA is a defender she choice a secret code.");
        if (GameState.devMode)
            GameColor.GREY.print("IA : \"my secret code is ", false);
        for (int i = 0; i < getRules().getNbEltInCode(); i++) {
            getSecretCodeArray()[i] = rand.nextInt(getRules().getNbColorInCode());
            if (GameState.devMode)
                GameColor.GREY.print(Integer.toString(getSecretCodeArray()[i]), false);
        }
        if (GameState.devMode)
            System.out.println("\".");
    }

    @Override
    public boolean winInAttack() {
        setiWin(true);
        GameColor.BLUE.print("\nIA called " + this.getName() + " WIN ATTACK !!!!!");
        myFirstLogger.info(this.getName() + " human WIN ATTACK");
        return isiWin();
    }

    @Override
    public void play() {
        if (GameState.gameChoosed == GameType.MASTERMIND)
            playMastermind();
        else
            playPlusOrMinus();
    }

    private void playPlusOrMinus() {
        String iaProposition = "";
        //premier tour
        if (firstTry) {
            firstTry = false;
            for (int i = 0; i < getRules().getNbEltInCode(); i++) {
                iaProposition += "5";
            }
            setProposition(iaProposition);
            return;
        }
        //second tour
        if (secondTry) {
            secondTry = false;
            for (int i = 0; i < getRules().getNbEltInCode(); i++) {
                if (getPreviousResponse().charAt(i) == '+') {
                    iaProposition += "7";
                } else if (getPreviousResponse().charAt(i) == '-') {
                    iaProposition += "2";
                } else
                    iaProposition += Integer.toString(getPropositionArray()[i]);
            }
            setProposition(iaProposition);
            return;
        }
        //other turns
        for (int i = 0; i < getRules().getNbEltInCode(); i++) {
            if (getPreviousResponse().charAt(i) == '+') {
                iaProposition += Integer.toString(getPropositionArray()[i] + 1);
            } else if (getPreviousResponse().charAt(i) == '-') {
                iaProposition += Integer.toString(getPropositionArray()[i] - 1);
            } else
                iaProposition += Integer.toString(getPropositionArray()[i]);
        }
        setProposition(iaProposition);
    }

    private void playMastermind() {
        Random rand = new Random();
        String iaProposition;

        //begin test all colors one by one for reduce allPossibilityList
        if (checkValidColor <= getRules().getNbColorInCode()) {
            checkValidColor(checkValidColor - 1);
            proposeUniqueColor(checkValidColor);
            checkValidColor += 1;
            return;
        } else if (checkValidColor == getRules().getNbColorInCode() + 1) {
            checkValidColor(checkValidColor - 1);
            checkValidColor += 1;
        }
        //delete previous bad possibility
        allPossibility.removeIf(i -> String.valueOf(i).equals(getProposition()));

        //propose new possibility
        iaProposition = String.valueOf(allPossibility.get(0));
        setProposition(iaProposition);
    }

    private void proposeUniqueColor(int nb) {
        String iaProposition = "";
        for (int i = 0; i < getRules().getNbEltInCode(); i++) {
            iaProposition += Integer.toString(nb);
        }
        setProposition(iaProposition);
    }

/*
    private void deleteMissingColor(String color) {
        lastBadValue = Character.getNumericValue(color.charAt(0));
        for (int i = 0; i < allPossibility.size(); i++) {
            if (allPossibility.get(i).toString().contains(color)) {
                allPossibility.remove(i);
                i--;
            }
        }
    }*/

    //check the previous result of unique color proposition to reduce list of all possibilities
    private void checkValidColor(int color) {
        if (getPreviousResponse().equals("Missing, nothing...")) {
            deleteBadPossibilityGoodPlace(Integer.toString(color), 0);
        } else {
            String[] rsp = getPreviousResponse().split(";", 2);
            int i = 0;
            for (String retval : rsp) {
                if (i == 1) {
                    deleteBadPossibilityGoodPlace(Integer.toString(color), Integer.parseInt(retval));
                }
                i++;
            }
        }
    }

    //search if possibility contains exactly the number of color expected in good place and delete others
    private void deleteBadPossibilityGoodPlace(String color, int nbGoodPlace) {
        final Pattern pattern = Pattern.compile("(" + color + ")", Pattern.MULTILINE);
        Matcher matcher;

        for (int i = 0; i < allPossibility.size(); i++) {
            matcher = pattern.matcher(allPossibility.get(i).toString());
            int j = 0;
            while (matcher.find()) {
                j++;
            }
            if (j != nbGoodPlace) {
                //System.out.println("remove : " + allPossibility.get(i).toString());
                allPossibility.remove(i);
                i--;
            }
        }
    }

}

