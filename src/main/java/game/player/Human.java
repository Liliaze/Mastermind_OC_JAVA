package game.player;

import game.GameState;
import game.rules.Rules;
import game.constante.GameColor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Human extends Player {

    private static Logger myFirstLogger = LogManager.getLogger(Human.class);

    public Human(Rules r, String nameTmp, Player en) {
        super(r, nameTmp, en);
        //add ask Name.
        System.out.println("a new Human is coming, his name is : " + name);
    }

    int[] propositionCode = new int[rules.nbEltInCode];

    @Override
    public void generateSecretCode() {
        if (!defender)
            return;
        GameColor.YELLOW.print(name + " type human is a defender, please choose your secret code : ");
        String str;
        do {
            GameColor.RED.print("Secret code must be contains " + rules.nbEltInCode + " nombre)");
            str = scanString();
        } while (!checkSecretCodeFormatFromString(str));

        for (int i = 0; i < rules.nbEltInCode; i++) {
            secretCodeArray[i] = Character.getNumericValue(str.charAt(i));
        }
    }

    @Override
    public boolean winInAttack() {
        iWin = true;
        GameColor.GREEN.print(this.name + " human WIN ATTACK !!!!", true);
        return iWin;
    }

    @Override
    public void play() {
        if (GameState.devMode)
            GameColor.BLUE.print("secret code is : " + arrayToInt(enemy.secretCodeArray));
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
            System.out.println("string = " + str);
            return str;
        } catch (Exception e) {
        }
        return "";
    }

}
