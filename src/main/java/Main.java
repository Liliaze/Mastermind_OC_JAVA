import game.GameState;
import game.Menu;
import game.RoundGame;
import game.rules.Rules;
import game.rules.RulesMastermind;
import game.rules.RulesPlusAndMinus;
import game.player.Human;
import game.player.IA;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.IOException;

public class Main {

    private static Logger myFirstLogger = LogManager.getLogger(Main.class);

    private static void launchARoundGame(Menu menu) {
        Rules rules = null;
        switch (GameState.gameChoosed) {
            case PLUS_AND_MINUS:
                rules = new RulesPlusAndMinus();
                break;
            case MASTERMIND:
                rules = new RulesMastermind();
                break;
            case EXIT:
                menu.displayGoodBye();
                break;
            default:
                menu.displayGoodBye();
                break;
        }

        RoundGame newRound = null;
        switch (GameState.modeChoosed) {
            case CHALLENGER:
                newRound = new RoundGame(new Human(rules, "JEAN"), null, new IA(rules, "MAITRE"), rules);
                break;
            case DEFENDER:
                newRound = new RoundGame(new IA(rules, "JEANNETTE"), null, new Human(rules, "ALTHEA"), rules);
                break;
            case DUAL:
                newRound = new RoundGame(new Human(rules, "ALTHEA"), new IA(rules, "JEANNETTE"), new IA(rules, "GAMEMASTER"), rules);
                break;
            case EXIT:
                menu.displayGoodBye();
                break;
            default:
                menu.displayGoodBye();
                break;
        }
        newRound.startRound();
    }

    public static void main(String[] args) {
        Menu menuGame = new Menu();
        int again;

        DOMConfigurator.configure("src/main/resources/log4j.xml");

        myFirstLogger.debug("i am debug message");
        myFirstLogger.error("i am error message");
        myFirstLogger.info("just an info");

        for (int i = 0; i < 50; ++i) System.out.println();
        System.out.println(""+
                ",---.    ,---.   ____       .-'''-. ,---------.    .-''-.  .-------.                       .-'''-.     .-''-.     ____    .-------.        _______   .---.  .---.  \n"+
                "|    \\  /    | .'  __ `.   / _     \\\\          \\ .'_ _   \\ |  _ _   \\                     / _     \\  .'_ _   \\  .'  __ `. |  _ _   \\      /   __  \\  |   |  |_ _|  \n"+
                "|  ,  \\/  ,  |/   '  \\  \\ (`' )/`--' `--.  ,---'/ ( ` )   '| ( ' )  |                    (`' )/`--' / ( ` )   '/   '  \\  \\| ( ' )  |     | ,_/  \\__) |   |  ( ' )  \n"+
                "|  |\\_   /|  ||___|  /  |(_ o _).       |   \\  . (_ o _)  ||(_ o _) /                   (_ o _).   . (_ o _)  ||___|  /  ||(_ o _) /   ,-./  )       |   '-(_{;}_) \n"+
                "|  _( )_/ |  |   _.-`   | (_,_). '.     :_ _:  |  (_,_)___|| (_,_).' __                  (_,_). '. |  (_,_)___|   _.-`   || (_,_).' __ \\  '_ '`)     |      (_,_)  \n"+
                "| (_ o _) |  |.'   _    |.---.  \\  :    (_I_)  '  \\   .---.|  |\\ \\  |  |   _ _     _ _  .---.  \\  :'  \\   .---..'   _    ||  |\\ \\  |  | > (_)  )  __ | _ _--.   |  \n"+
                "|  (_,_)  |  ||  _( )_  |\\    `-'  |   (_(=)_)  \\  `-'    /|  | \\ `'   /--( ' )---(_I_)-\\    `-'  | \\  `-'    /|  _( )_  ||  | \\ `'   /(  .  .-'_/  )|( ' ) |   |  \n"+
                "|  |      |  |\\ (_ o _) / \\       /     (_I_)    \\       / |  |  \\    /  (_{;}_) (_(=)_) \\       /   \\       / \\ (_ o _) /|  |  \\    /  `-'`-'     / (_{;}_)|   |  \n"+
                "'--'      '--' '.(_,_).'   `-...-'      '---'     `'-..-'  ''-'   `'-'  --(_,_)---(_I_)-  `-...-'     `'-..-'   '.(_,_).' ''-'   `'-'     `._____.'  '(_,_) '---'  \n"+
                "   ____             _______       ,-----.      ___    _  ______        ____     __  _ _    .-'''-.           .-_'''-.      ____    ,---.    ,---.    .-''-.        \n"+
                " .'  __ `.         \\  ____  \\   .'  .-,  '.  .'   |  | ||    _ `''.    \\   \\   /  /( ' )  / _     \\         '_( )_   \\   .'  __ `. |    \\  /    |  .'_ _   \\       \n"+
                "/   '  \\  \\        | |    \\ |  / ,-.|  \\ _ \\ |   .'  | || _ | ) _  \\    \\  _. /  '(_{;}_)(`' )/`--'        |(_ o _)|  ' /   '  \\  \\|  ,  \\/  ,  | / ( ` )   '      \n"+
                "|___|  /  |        | |____/ / ;  \\  '_ /  | :.'  '_  | ||( ''_'  ) |     _( )_ .'  (_,_)(_ o _).           . (_,_)/___| |___|  /  ||  |\\_   /|  |. (_ o _)  |      \n"+
                "   _.-`   |        |   _ _ '. |  _`,/ \\ _/  |'   ( \\.-.|| . (_) `. | ___(_ o _)'         (_,_). '.         |  |  .-----.   _.-`   ||  _( )_/ |  ||  (_,_)___|      \n"+
                ".'   _    |        |  ( ' )  \\: (  '\\_/ \\   ;' (`. _` /||(_    ._) '|   |(_,_)'         .---.  \\  :        '  \\  '-   .'.'   _    || (_ o _) |  |'  \\   .---.      \n"+
                "|  _( )_  |        | (_{;}_) | \\ `\"/  \\  ) / | (_ (_) _)|  (_.\\.' / |   `-'  /          \\    `-'  |         \\  `-'`   | |  _( )_  ||  (_,_)  |  | \\  `-'    /      \n"+
        "\\ (_ o _) /        |  (_,_)  /  '. \\_/``\".'   \\ /  . \\ /|       .'   \\      /            \\       /           \\        / \\ (_ o _) /|  |      |  |  \\       /       \n"+
        " '.(_,_).'         /_______.'     '-----'      ``-'`-'' '-----'`      `-..-'              `-...-'             `'-...-'   '.(_,_).' '--'      '--'   `'-..-'        \n"
                                                                                                                                                                   );

        do {
            menuGame.displayWelcomeMenu();
            do {
                launchARoundGame(menuGame);
                again = menuGame.again();
                GameState.reinitParty();
            } while (again == 1);
            GameState.reinitAllGameState();
        } while (again == 2);
        menuGame.displayGoodBye();
    }
}
