import java.util.Scanner;

public class mainClass {
    static Scanner sc = new Scanner(System.in);
    static int maxAttemps = 8;

    public static void main(String[] args) {
        theMan theMan = new theMan();

        MessageOut(theMan.theMan[7]);
        menu gameMenu = new menu();

        Boolean isTrue = true;

        while (isTrue) {
            //
            MessageOut("Welcome to Hangman.\nEnter 1.Start the game 2.Options 3.Exit the game");
            String userInput = sc.nextLine();

            switch (userInput) {
                case "1":
                    gameMenu.gameMenu(sc);
                    break;
                // case "2":
                // Options();
                // break;
                case "3":
                    MessageOut("Thank you for playing.");
                    isTrue = false;
                    break;
                default:
                    MessageOut("Please enter a valid number from above");
                    userInput = sc.nextLine();
                    break;
            }

        }
        sc.close();;
    }
    // public static void Options(){
    // maxAttemps = Integer.parseInt(sc.nextLine());
    // }

    public static void MessageOut(String text) {
        // dont want to type "System.out.println()" everytime
        System.out.println(text);
    }
}