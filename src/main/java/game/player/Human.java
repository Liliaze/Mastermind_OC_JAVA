package game.player;

import game.rules.Rules;
import game.constante.GameColor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Human extends Player {

    private static Logger myFirstLogger = LogManager.getLogger(Human.class);

    public Human(Rules r, String nameTmp, Player en) {
        super(r, nameTmp, en);
        myFirstLogger.debug("a new Human is coming, his name is : " + name);
    }

    @Override
    public void generateSecretCode() {
        if (!defender)
            return;
        GameColor.YELLOW.print(name + " type human is a defender, please choose your secret code : ");
        String str;
        do {
            GameColor.RED.print("Secret code must be contains " + rules.nbEltInCode + " number");
            str = scanString();
        } while (!checkSecretCodeFormatFromString(str));

        for (int i = 0; i < rules.nbEltInCode; i++) {
            secretCodeArray[i] = Character.getNumericValue(str.charAt(i));
        }
    }

    @Override
    public boolean winInAttack() {
        iWin = true;
        GameColor.GREEN.print("\n" + this.name + " human WIN ATTACK !!!!", true);
        myFirstLogger.info(this.name + " human WIN ATTACK" );
        return iWin;
    }

    @Override
    public void play() {
        String str;
        do {
            str = scanString();
        } while (!checkSecretCodeFormatFromString(str));
        setProposition(str);
    }

    private String scanString() {
        Scanner sc = new Scanner(System.in);

        try {
            String str = sc.nextLine();
            return str;
        } catch (Exception e) {
        }
        return "";
    }

}
