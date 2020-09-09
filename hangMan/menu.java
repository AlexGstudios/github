import java.util.Scanner;

public class menu {
    private gameCheck gameCheck = new gameCheck();
    private theMan theMan = new theMan();
    private Scanner sc = mainClass.sc;
    private int tries = 0;
    private String guessCheck = " ";
    // colors for the text: reset green yellow red
    private static String[] colors = { "\033[0m", "\033[0;32m", "\033[0;33m", "\033[0;31m" };

    public void gameMenu(Scanner sc) {
        // method to get the userinput for the different options
        String stringMenu = " ";
        Boolean isTrue = true;
        tries = 0;
        gameCheck.Setup();

        while (isTrue) {
            // while-loop for the different guess-options
            MessageOut("Enter one of the following options.\nStatus (1), Letter (2), Word (3)");
            stringMenu = sc.nextLine().toLowerCase();
            switch (Choice(stringMenu)) {
                case "1":
                    Status();
                    break;
                case "2":
                    Letter();
                    break;
                case "3":
                    Word();
                    break;
                default:
                    MessageOut("Status will show you how many chances you have left\n"
                            + "Letter lets you enter a letter to guess\n"
                            + "Word will let you guess the whole word, but if you guess incorrect you will lose.");
                    stringMenu = sc.nextLine();
                    break;
            }
            // checks for loss or win
            if (tries == mainClass.maxAttemps) {
                MessageOut(colors[3] + "You lost, the awnser was: " + gameCheck.Awnser() + colors[0]);
                isTrue = false;
            }
            if (guessCheck.equals(gameCheck.Awnser())) {
                MessageOut(colors[1] + "Congratulations, you've won the game!\nYou awnsered " + gameCheck.Awnser()
                        + colors[0]);
                isTrue = false;
            }
        }
    }

    public void AddTries() {
        // method to add tries and check the different success-stages
        if (gameCheck.Success() == 0) {
            tries = tries + 1;
            for (int i = tries; i < tries + 1; i++) {
                MessageOut(theMan.theMan[i]);
            }
        } else if (gameCheck.Success() == 1) {
            guessCheck = gameCheck.GetCharList();
            gameCheck.ResetSucces();
        } else if (gameCheck.Success() == 2) {
            tries = mainClass.maxAttemps;
            gameCheck.ResetSucces();
        }
    }

    public String Choice(String userInput) {
        // if the user types the choices given. convert them to numbers
        // for the switch-statement
        if (userInput.equals("status")) {
            userInput = "1";
        } else if (userInput.equals("letter")) {
            userInput = "2";
        } else if (userInput.equals("word")) {
            userInput = "3";
        }
        return userInput;
    }

    private void Status() {
        // method that shows the tries left for the player
        MessageOut("status");
        MessageOut("The number of tries you have used: " + tries);
        MessageOut("The number of tries you have left is: " + (mainClass.maxAttemps - tries));
    }

    private void Letter() {
        // method that takes the first letter from the string
        // if the user types more then one char
        MessageOut("Type a letter you want to guess");
        String str = sc.nextLine();
        char guess = str.charAt(0);

        gameCheck.Guess(guess);
        AddTries();
    }

    private void Word() {
        // method that takes the whole word to check
        MessageOut("Type the word you want to guess");
        String guess = sc.nextLine();
        gameCheck.WordGuess(guess);
        AddTries();
    }

    public void MessageOut(String text) {
        // dont want to type "System.out.println()" everytime
        System.out.println(text);
    }
}