// This is not 100% what Marcus wants us to do
// but this might get you on the right track
import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.Scanner;

public class findandreplace {
    
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Please type a word you would like to find: ");

        String word = sc.nextLine();

        FindWord(word);

        System.out.println("Press the number 1 key if you want to change the word " + word);

        int num = 0;

        num = Integer.parseInt("0" + sc.nextLine());

        if(num == 1){
            System.out.println("What word do you want to change it to?");
            
            String newWord = sc.nextLine();

            ChangeWord(newWord, word);
                
        }else
            System.out.println("No word has been changed.");

        sc.close();
    }
    public static void FindWord(String word) throws IOException{
        
        File file = new File("C:/Users/Alexander/Desktop/javatest.txt"); // (if you use this) Change the path to sample.csv
                                                                         // if you have pasted the .csv file to your project

        String[] words = null;

        FileReader fileRead = new FileReader(file);

        BufferedReader bufferedRead = new BufferedReader(fileRead);

        String s;

        int count = 0;

        while((s = bufferedRead.readLine()) != null){

            words = s.split(" ");

            for(String w : words){
                if(w.equals(word)){
                    count++;
                }
            }
            
        }

        if(count != 0){
            System.out.println("The word " + word + " that you chose to search for appears " + count + " times.");
        }
        else
        System.out.println("The word " + word + " does not appear in the text.");

        fileRead.close();
    }
    public static void ChangeWord(String newWord, String word) throws IOException{
       
        Path path = Paths.get("C:/Users/Alexander/Desktop/javatest.txt"); // (if you use this) Change the path to sample.csv
                                                                          // if you have pasted the .csv file to your project
        Charset charset = StandardCharsets.US_ASCII;

        String content = new String(Files.readAllBytes(path), charset);

        content = content.replaceAll(word, newWord);

        Files.write(path, content.getBytes(charset));
    }
}