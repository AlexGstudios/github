import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class rockPaperScissors {
    // assigns color to the text, MessageOut();
    // reset green yellow red
    private static String[] colors = { "\033[0m", "\033[0;32m", "\033[0;33m", "\033[0;31m" };
    
    // declares the three different objects
    private static userValues userValues1 = new userValues();
    private static userValues userValues2 = new userValues();
    private static userValues userValues3 = new userValues();

    public static void main(String[] args) {

        // initializes the values
        userValues1.ID = 0;
        userValues1.name = "rock";
        userValues1.beats = "scissors";

        userValues2.ID = 1;
        userValues2.name = "paper";
        userValues2.beats = "rock";

        userValues3.ID = 2;
        userValues3.name = "scissors";
        userValues3.beats = "paper";

        // Scanner'n initialized
        Scanner sc = new Scanner(System.in);

        // bool initialized to true
        Boolean isTrue = true;

        // the game starts and ask's if you want to play as one player against the
        // computer
        // or against a friend as two players
        MessageOut("Do you want to play single or multiplayer?\nType one for one player and two for two players"
                + "\nYou can also rename the three values to your choice, type rename");
        // String that takes the user input and sets it to lower case
        // used to determen if the user wants to play alone or with a friend
        String gameMode = sc.nextLine().toLowerCase();

        // while loop that loops until the game is finished
        while (isTrue) {

            // switch that checks what game mode
            switch (gameMode) {
                case "one":
                    MessageOut("Enter " + userValues1.name + ", " + userValues2.name + " or " + userValues3.name);
                    // gets the user input
                    String choice = sc.nextLine().toLowerCase();

                    //if the user enters a numeric value this method turns it to
                    //one of the correct values int the String[] choices
                    choice = UserNumToString(choice);

                    // declares and initializes user with the method UserInput
                    // UserInput explained further down
                    userValues user = UserInput(choice);

                    // declares and initializes computer with the method RockPaperScissors
                    // RockPaperScissors explained further down
                    userValues computer = RockPaperScissors();

                    // method that checks who will win
                    isTrue = GameCheck(user, computer, isTrue, 0);

                    // breaks out of this switch-case
                    break;

                case "two":
                    MessageOut("Player one, please enter Rock, Paper or Scissors: ");
                    // gets the user input
                    String playerOne = sc.nextLine().toLowerCase();
                    MessageOut("Player two, please enter Rock, Paper or Scissors: ");
                    // gets the user input
                    String playerTwo = sc.nextLine().toLowerCase();

                    //if the user enters a numeric value this method turns it to
                    //one of the correct values int the String[] choices
                    playerOne = UserNumToString(playerOne);

                    //if the user enters a numeric value this method turns it to
                    //one of the correct values int the String[] choices
                    playerTwo = UserNumToString(playerTwo);

                    // declares and initializes playerOneChoice with the method UserInput
                    // UserInput explained further down
                    userValues playerOneChoice = UserInput(playerOne);
                    // declares and initializes playerTwoChoice with the method UserInput
                    // UserInput explained further down
                    userValues playerTwoChoice = UserInput(playerTwo);

                    // method that checks who will win
                    isTrue = GameCheck(playerOneChoice, playerTwoChoice, isTrue, 1);
                    // breaks out of this switch-case
                    break;
                case "rename":
                    // method to change the rock, paper and scissors values
                    // ex -> fist, hand and peace
                    ChangeValues(sc);

                    MessageOut(
                            "Do you want to play single or multiplayer?\nType one for one player and two for two players"
                                    + "\nYou can also rename the three values to your choice, type rename");
                    // String that takes the user input and sets it to lower case
                    // used to determen if the user wants to play alone or with a friend
                    gameMode = sc.nextLine().toLowerCase();
                    // breaks out of this switch-case
                    break;
                default:
                    // defauld case to catch the error in the userinput
                    MessageOut("Please enter one for one player or two for two players");
                    MessageOut(
                            "Do you want to play single or multiplayer?\nType one for one player and two for two players");
                    // lets the user try again to enter a valid input
                    gameMode = sc.nextLine().toLowerCase();
                    // breaks out of this switch-case
                    break;
            }

        }
        // will close the Scanner when the game is done
        sc.close();
    }

    public static void MessageOut(String text) {
        // this method will print out the String given from the param
        System.out.println(text);
    }

    public static String UserNumToString (String text){
        //new String to return
        String choice = new String();

        // an String[] that is used as a check but aslo in the method MessageOut()
        String[] choices = { userValues1.name, userValues2.name, userValues3.name };

        //if statement to change the user input to a String
        if(text.equals("1")){
            choice = choices[0];
        }else if(text.equals("2")){
            choice = choices[1];
        }else if(text.equals("3")){
            choice = choices[2];
        }else{
            choice = text;
        }
        //returns the String
        return choice;
    }

    public static Boolean GameCheck(userValues user, userValues computer, Boolean isTrue, int singMulti) {
        // this method will check either the user and comp or the two users diffrent
        // choices

        // an String[] that is used as a check but aslo in the method MessageOut()
        String[] choices = { userValues1.name, userValues2.name, userValues3.name };

        // String[] to use in MessageOut to determine if MessageOut shoud print computer
        // o player two
        String[] computerOrPlayer = { "The computer", "Player two" };

        // the if-statments that determines the outcome

        // first if-statement checks if the two opponents have given the same value
        if (user.name.equals(computer.name)) {
            MessageOut(colors[2] + "You choosed " + choices[user.ID] + " and " + computerOrPlayer[singMulti]
                    + " choosed " + choices[computer.ID] + colors[0]);
            MessageOut(colors[2] + "You have to try again" + colors[0]);
        }
        // checks if the player one has won
        else if (user.beats.equals(computer.name)) {
            MessageOut(colors[1] + "Player one wins, " + computerOrPlayer[singMulti] + " choosed "
                    + choices[computer.ID] + colors[0]);
            isTrue = false;
        }
        // else player one will lose
        else {
            MessageOut(colors[1] + computerOrPlayer[singMulti] + " choosed " + choices[computer.ID]
                    + " and wins the game" + colors[0]);
            isTrue = false;
        }
        // returns the boolean to exit the while-loop so the program will end
        return isTrue;
    }

    public static userValues UserInput(String choice) {
        // method to check the userInput and initializes the right object to it

        // an String[] that is used as a check but aslo in the method MessageOut()
        String[] choices = { userValues1.name, userValues2.name, userValues3.name };

        // initializes the variable type so it can return the right values
        // from the correspondant userInput->choice
        userValues type = userValues1;

        // for-loop to cycle the String[].length
        for (int i = 0; i < choices.length; i++) {
            // if-statement to check if the userInput equals the String[]
            // with index i from the loop
            if (choice.equals(choices[i])) {
                // switch-statement to initialize the type
                switch (i) {
                    case 0:
                        type = userValues1;
                        break;
                    case 1:
                        type = userValues2;
                        break;
                    case 2:
                        type = userValues3;
                        break;
                }
            }
        }

        // returns the correct value
        return type;
    }

    public static userValues RockPaperScissors() {
        // method that gets a random number

        // an String[] that is used as a check but aslo in the method MessageOut()
        String[] choices = { userValues1.name, userValues2.name, userValues3.name };

        // initializes int random with a random number
        int random = ThreadLocalRandom.current().nextInt(0, 3);
        // initializes String comp with the correct value from the array
        String comp = choices[random];

        // method UserInput initializes computer with the correct value
        userValues computer = UserInput(comp);
        // returns a userValues, either
        return computer;
    }

    public static void ChangeValues(Scanner sc) {
        // method to change the names and what they beat

        // Pritnln
        MessageOut("Please type in the three values you want to use instead of Rock, Paper and Scissors"
                + "\nand what it beats");

        MessageOut(colors[2] + "Please type in a new value instead of rock" + colors[0]);
        // sets new values to the objects userValues1 -> 3
        userValues1.name = sc.nextLine();
        MessageOut(colors[2] + "and what " + userValues1.name + " beats" + colors[0]);
        userValues1.beats = sc.nextLine();

        MessageOut(colors[2] + "Please type in a new value instead of paper" + colors[0]);
        userValues2.name = sc.nextLine();
        MessageOut(colors[2] + "and what " + userValues2.name + " beats" + colors[0]);
        userValues2.beats = sc.nextLine();

        MessageOut(colors[2] + "Please type in a new value instead of scissors" + colors[0]);
        userValues3.name = sc.nextLine();
        MessageOut(colors[2] + "and what " + userValues3.name + " beats" + colors[0]);
        userValues3.beats = sc.nextLine();
    }
}
