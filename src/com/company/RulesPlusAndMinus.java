package com.company;

public class RulesPlusAndMinus extends Rules {

    RulesPlusAndMinus() {
        System.out.println("This game is under Plus and Minus Rules");
    }

    public boolean checkVictory(Player player) {
        if (player == null)
            return false;
        if (player.proposition < GameState.secretCodeInt) {
            System.out.println("c'est moins");
        } else if (player.proposition == GameState.secretCodeInt) {
            System.out.println("c'est bon");
            return true;
        } else
            System.out.println("c'est plus");
        return false;
    }
}
