package game.player;

import game.rules.Rules;
import game.constante.GameColor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Human extends Player {

    private static final Logger myFirstLogger = LogManager.getLogger(Human.class);

    public Human(Rules r, String nameTmp, Player en) {
        super(r, nameTmp, en);
        myFirstLogger.debug("a new Human is coming, his name is : " + getName());
    }

    @Override
    public void generateSecretCode() {
        if (!isDefender())
            return;
        GameColor.YELLOW.print(getName() + " type human is a defender, please choose your secret code : ");
        String str;
        do {
            GameColor.RED.print("Secret code must be contains " + getRules().getNbEltInCode() + " number");
            str = scanString();
        } while (!checkSecretCodeFormatFromString(str));

        for (int i = 0; i < getRules().getNbEltInCode(); i++) {
            getSecretCodeArray()[i] = Character.getNumericValue(str.charAt(i));
        }
    }

    @Override
    public boolean winInAttack() {
        setiWin(true);
        GameColor.GREEN.print("\n" + this.getName() + " human WIN ATTACK !!!!", true);
        myFirstLogger.info(this.getName() + " human WIN ATTACK" );
        return isiWin();
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
