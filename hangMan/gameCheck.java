import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class gameCheck {
    private class ProduceAwnsers {
        // private class for the awnser
        private String[] awnser = { "dog", "bumblebee", "bird" };
        private String text = " ";

        public void Random() {
            // randomizes the awnser
            int random = ThreadLocalRandom.current().nextInt(0, 3);
            text = awnser[random];
        }

        public String GetAwnser() {
            // gets the awnser created from the random method
            String correctAwnser = text;
            return correctAwnser;
        }
    }

    ProduceAwnsers awnser = new ProduceAwnsers();
    private static char[] awnserArr = {};
    private static List<Character> charList = new ArrayList<Character>();
    private static int success = 0;

    public void Setup() {
        // method to setup different variables when the game starts
        awnser.Random();
        awnserArr = awnser.GetAwnser().toCharArray();
        charList.clear();
        for (int i = 0; i < awnser.GetAwnser().length(); i++) {
            charList.add(i, '*');
        }
    }

    public void Guess(char guess) {
        // method for char guesses
        for (int i = 0; i < awnser.GetAwnser().length(); i++) {
            if (guess == awnserArr[i]) {
                charList.set(i, guess);
                success = 1;
            }
        }
        System.out.println(GetCharList());
    }

    public void WordGuess(String guess) {
        // method for guessing the whole word
        if (guess.equals(awnser.GetAwnser())) {
            char[] guessCharArr = guess.toCharArray();
            for (int i = 0; i < awnser.GetAwnser().length(); i++) {
                charList.set(i, guessCharArr[i]);
                success = 1;
            }
        } else {
            success = 2;
        }
    }

    public int Success() {
        // method for reaching the different states of success
        return success;
    }

    public void ResetSucces() {
        // resets success
        success = 0;
    }

    public String Awnser() {
        // makes the awnser available to other classes and methods
        return awnser.GetAwnser();
    }

    public String GetCharList() {
        // method that shows the right guessed char's
        // types * otherwise
        String charToString = " ";
        char a = ' ';
        char[] x = new char[awnser.GetAwnser().length()];

        for (int i = 0; i < awnser.GetAwnser().length(); i++) {
            a = charList.get(i);
            x[i] = a;
            charToString = String.valueOf(x);
        }

        return charToString;
    }
}