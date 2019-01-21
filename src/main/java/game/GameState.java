package game;

import game.constante.GameColor;
import game.constante.GameType;
import game.constante.GameMode;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GameState {
    private static Logger myFirstLogger = LogManager.getLogger(GameState.class);

    private static GameState ourInstance = new GameState();

    public static GameState getInstance() {
        return ourInstance;
    }

    public static GameType gameChoosed;
    public static GameMode modeChoosed;
    public static int nbEltInSecretCodeMastermind;
    public static int nbEltInSecretCodePlusOrMinus;
    public static int nbColorInSecretCodeMastermind;
    public static int nbTryMax;
    public static int nbTryMaxMastermind;
    public static int nbTryMaxPlusOrMinus;
    public static String playerName;
    public static boolean devMode;

    InputStream inputStream;

    private GameState() {
        gameChoosed = GameType.EXIT;
        modeChoosed = GameMode.EXIT;
        try {
            loadProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reinitAllGameState() {
        gameChoosed = GameType.EXIT;
        modeChoosed = GameMode.EXIT;
    }

    private void loadProperties() throws IOException {
        try {
            final Properties prop = new Properties();
            final String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                myFirstLogger.error("property file '" + propFileName + "' not found in the classpath");
                GameColor.RED.print("Sorry, one file is missing, error is encounter");
                Menu.displayGoodBye();
            }
            nbEltInSecretCodePlusOrMinus = checkPropertyValue(Integer.parseInt(prop.getProperty("nbEltPlusOrMinus")), 4, 0, 10);
            nbEltInSecretCodeMastermind = checkPropertyValue(Integer.parseInt(prop.getProperty("nbEltMastermind")), 4, 0, 10);
            nbColorInSecretCodeMastermind = checkPropertyValue(Integer.parseInt(prop.getProperty("nbColorMastermind")), 4, 4, 10);
            nbTryMaxPlusOrMinus = checkPropertyValue(Integer.parseInt(prop.getProperty("nbTryMaxPlusOrMinus")), 8, 1, Integer.MAX_VALUE);
            nbTryMaxMastermind = checkPropertyValue(Integer.parseInt(prop.getProperty("nbTryMaxMastermind")), 15, 1, Integer.MAX_VALUE);
            if (!devMode)
                devMode = Boolean.parseBoolean(prop.getProperty("devMode"));
            playerName = prop.getProperty("yourDevName");
            if (playerName.length() < 1 || playerName.length() > 150 ||playerName.equals(""))
                playerName = "ALTHEA";

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
    }

    private int checkPropertyValue(int valueToTest, int defaultValue, int min, int max) {
        if (valueToTest < min || valueToTest > max)
            return defaultValue;
        else
            return valueToTest;
    }
}
