package game.player;

import game.GameState;
import game.rules.Rules;
import game.constante.GameType;
import game.constante.GameColor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Random;

public class IA extends Player {
    private static final Logger myFirstLogger = LogManager.getLogger(IA.class);

    private boolean firstTry = true;
    private boolean secondTry = true;

    public IA(Rules r, String nameTmp, Player en) {
        super(r, nameTmp, en);
        myFirstLogger.debug("a new IA is coming, his name is : " + getName());
    }

    @Override
    public void generateSecretCode() {
        Random rand = new Random();
        GameColor.YELLOW.print(getName() + " type IA is a defender she choice a secret code.");
        if (GameState.devMode)
            GameColor.GREY.print("IA : \"my secret code is ", false);
        for (int i = 0; i < getRules().nbEltInCode; i++) {
            getSecretCodeArray()[i] = rand.nextInt(getRules().nbColorInCode);
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
        myFirstLogger.info(this.getName() + " human WIN ATTACK" );
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
            for (int i = 0; i < getRules().nbEltInCode; i++) {
                iaProposition += "5";
            }
            setProposition(iaProposition);
            return;
        }
        //second tour
        if (secondTry) {
            secondTry = false;
            for (int i = 0; i < getRules().nbEltInCode; i++) {
                if (previousResponse.charAt(i) == '+') {
                    iaProposition += "7";
                } else if (previousResponse.charAt(i) == '-') {
                    iaProposition += "2";
                } else
                    iaProposition += Integer.toString(getPropositionArray()[i]);
            }
            setProposition(iaProposition);
            return;
        }
        //autres tour
        for (int i = 0; i < getRules().nbEltInCode; i++) {
            if (previousResponse.charAt(i) == '+') {
                iaProposition += Integer.toString(getPropositionArray()[i] + 1);
            } else if (previousResponse.charAt(i) == '-') {
                iaProposition += Integer.toString(getPropositionArray()[i] - 1);
            } else
                iaProposition += Integer.toString(getPropositionArray()[i]);
        }
        setProposition(iaProposition);
    }

    private void playMastermind() {
        Random rand = new Random();
        String iaProposition = "";

        for (int i = 0; i < getRules().nbEltInCode; i++) {
            iaProposition += Integer.toString(rand.nextInt(getRules().nbColorInCode));
        }
        setProposition(iaProposition);
    }
}
