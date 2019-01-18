*project3 : Put your logic to the test**

**Description**

This application allows to play two games of logic.

The game searches +/-, you have to find a combination with +/- indications.
The game of mastermind is the same principle as the first game, except that the indications are well placed or present.

For each game, there are three different modes:
  - `CHALLENGER` mode, you have to find the secret combination of the computer.
  - `DEFENDER` mode is the computer that must find the combination proposed by the user.
  - the `DUAL` mode, where the computer and the user play in turn. The first who finds the combination of the other has won.
  
The application works like this:

A menu is displayed to suggest the user to choose one of the two games (search +/- or mastermind). Another menu allows you to select the game mode (challenger, defender or duel). If the user loses the application displays the solution. At the end of the program, the user can either replay the same mode or another, or stop and return to the first menu. 


The player can leave the application in two ways:
 - during the menus by selecting choice number 3: EXIT
 - during this code proposals, typing 'exit' or 'q'

**configuration**

A configuration file `config.properties` is at your disposal to modify the main rules of the game:

| property              | example of value     | description |
|:----------------------|:---------------------|:-------------------------|
|CONFIG DEVELOPER MODE  |
| devMode               | true | if you want display the secret code to find |
| yourDevName           | ALTHEA   | to set your player name  |
| MASTERMIND PROPERTIES |
| nbTryMaxMastermind    | 12  | define the number of turn of the Mastermind game  |
| nbEltMastermind       | 4  | define the number of ellement that composed the secret code of the Mastermind game  |
| nbColorMastermind     | 6  | define the number of color or here the max value of one number of the secret code of the Mastermind game  |
| PLUS OR MINUS PROPERTIES  |
| nbTryMaxPlusOrMinus   | 8  | define the number of turn of the +/- search game   |
| nbEltPlusOrMinus      | 4  | define the number of element that composed the secret code of the +/- search game |


**install**

**run**