package com.company;

import java.util.Scanner;

import static com.company.gameConstante.GameColor.*;

public class PlayerHuman extends Player {

    PlayerHuman(Rules r, String nameTmp) {
        super(r, nameTmp);
        //add ask Name.
        System.out.println("a new Human is coming, his name is : " + name);
    }

    int[] propositionCode = new int[GameState.nbEltInSecretCode];

    @Override
    public int[] generateSecretCode() {
        System.out.println(name + " is the defender, please choose the secret code. ");
        String str;
        do {
            System.out.println("(Secret code must be contains " + GameState.nbEltInSecretCode + " nombre)");
            str = scanString();
        } while (!checkSecretCodeFormatFromString(str));
        int[] tmpSecretCode = new int[GameState.nbEltInSecretCode];
        for (int i = 0; i < GameState.nbEltInSecretCode; i++) {
            tmpSecretCode[i] = Character.getNumericValue(str.charAt(i));
        }
        return tmpSecretCode;
    }

    @Override
    public boolean win() {
        iWin = true;
        GREEN.print(this.name + " type HUMAN WIN !!!!!", true);
        return iWin;
    }

    @Override
    public void play() {
        System.out.println("secret code i search is : " + GameState.secretCodeInt);
        System.out.println("So, i'm propose :");
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
