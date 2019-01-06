package com.company;

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
        System.out.println("HUMAN WIN !!!!!");
        return iWin;
    }

}
