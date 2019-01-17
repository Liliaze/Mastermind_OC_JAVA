package game;

import game.constante.GameColor;
import game.rules.Rules;
import game.player.Player;

public class RoundGame {

    Player secretAgent1;
    Player secretAgent2;
    Player masterGame;
    Rules rules;
    int nbTrying;

    public RoundGame(Player one, Player two, Player defender, Rules rls) {
        this.secretAgent1 = one;
        this.secretAgent2 = two;
        this.masterGame = defender;
        //game.GameState.setSecretCodeArray(this.secretAgent1.generateSecretCode()); // tmp test human
        GameState.setSecretCodeArray(this.masterGame.generateSecretCode());
        this.rules = rls;
        this.nbTrying = 0;
        GameColor.BLUE.print("WELCOME IN : " + rls.gameType);
        GameColor.CYAN.print(rls.gameType.getRulesDsc());
        GameColor.CYAN.print("The secretCode is constituted of " + rls.nbEltInCode + " number/color. Good luck !");
    }


    public void startRound() {
        do {
            GameColor.PINK.print("tour = " + nbTrying);
            if (secretAgent1 != null)
                secretAgent1.play();
            if (secretAgent2 != null)
                secretAgent2.play();
            nbTrying += 1;
        } while (!rules.checkEnd(nbTrying, secretAgent1, secretAgent2, masterGame));
    }
}
