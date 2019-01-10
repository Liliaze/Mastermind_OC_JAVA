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
        System.out.println("my code is 1248");
        return new int[] {1 ,2, 4, 8};
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
        setProposition(scanInt());
        while (propositionArray.length < GameState.nbEltInSecretCode) {
            setProposition(scanInt());
        }
    }

    private int scanInt() {
        System.out.println("scan here");
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        }
        catch (Exception e) {
        }
        return 0;
    }

}
