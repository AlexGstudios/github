import java.util.Scanner;

public class cipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Boolean quit = true;
        int input = 0;
        while (quit) {
            MessageOut("Would you like to Cipher or Decipher a text?");
            try {
                MessageOut("Enter a numeric value.\n 1. To cipher your text"
                        + "\n 2. To decipher your text\n Enter a value: ");
                input = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("\n");
            }
            switch (input) {
                case 1:
                    MessageOut("Enter what you want to cipher: ");
                    String textInput = sc.nextLine();
                    TextCipher(textInput);
                    break;
                case 2:
                    MessageOut("Enter what you want to decioher: ");
                    String textInput2 = sc.nextLine();
                    Decipher(textInput2);
                    break;
                default:
                    System.out.println("Please enter a numeric value");
            }
        }
        sc.close();
    }

    public static void MessageOut(String text) {
        System.out.println(text);
    }

    public static void TextCipher(String text) {
        // char[] alfabet som grund att kolla mot
        // fundera om man kan ha a...>ö istället
        char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ' };

        // char[] inputCharArray tar emot String text.getChar
        // används för att kolla mot alfabet
        char[] inputCharArray = {};

        // gör String text till lowercase (små bokstäver)
        text.toLowerCase();

        // gör om String text till char[] och lägger arrayen i inputCharArray
        // text.getChars(0, text.length(), inputCharArray, 0);

        inputCharArray = text.toCharArray();

        // char[] cipheredArray används som "mellanhand"
        // fylls upp med den chiffrade String text > inputCharArray
        char[] cipheredArray = new char[inputCharArray.length];

        // for loop som loopar genom inputCharArray.length
        for (int i = 0; i < inputCharArray.length; i++) {
            char inputLetter = inputCharArray[i];
            for (int a = 0; a < alphabet.length; a++) {
                char alphaberLetter = alphabet[a];
                if (inputLetter == alphaberLetter) {
                    if (Character.isWhitespace(alphaberLetter)) {
                        cipheredArray[i] = alphabet[alphabet.length - 1];
                    } else if (alphaberLetter < alphabet[17]) {
                        cipheredArray[i] = alphabet[a + 10];
                    } else if (alphaberLetter == alphabet[a]) {
                        cipheredArray[i] = alphabet[a - 16];
                    }
                }
            }
        }
        String cipheredString = new String(cipheredArray);
        MessageOut(cipheredString);

    }

    public static void Decipher(String text) {

        // char[] alfabet som grund att kolla mot
        // fundera om man kan ha a...>ö istället
        char[] alphabet = { ' ', 'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j',
                'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a' };

        // char[] inputCharArray tar emot String text.getChar
        // används för att kolla mot alfabet
        char[] inputCharArray = {};

        // gör String text till lowercase (små bokstäver)
        text.toLowerCase();

        // gör om String text till char[] och lägger arrayen i inputCharArray
        // text.getChars(0, text.length(), inputCharArray, 0);
        inputCharArray = text.toCharArray();

        // char[] cipheredArray används som "mellanhand"
        // fylls upp med den chiffrade String text > inputCharArray
        char[] cipheredArray = new char[inputCharArray.length];

        // for loop som loopar genom inputCharArray.length
        for (int i = 0; i < inputCharArray.length; i++) {
            char inputLetter = inputCharArray[i];
            for (int a = 0; a < alphabet.length; a++) {
                char alphaberLetter = alphabet[a];
                if (inputLetter == alphaberLetter) {
                    // mellanslag fuckar upp
                    if (Character.isWhitespace(alphaberLetter)) {
                        cipheredArray[i] = alphabet[a];
                    } else if (alphaberLetter > alphabet[17]) {
                        cipheredArray[i] = alphabet[a + 10];
                    } else if (alphaberLetter == alphabet[a]) {
                        cipheredArray[i] = alphabet[a - 16];
                    }
                }
            }
        }
        String cipheredString = new String(cipheredArray);
        MessageOut(cipheredString);
    }
}