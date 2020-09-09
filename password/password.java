import java.util.Scanner;

public class password
{
    //                                  reset       green         yellow         red
    private static String[] colors = {"\033[0m", "\033[0;32m", "\033[0;33m", "\033[0;31m"};
    private static String user, pass, username, password, change;
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) 
    {
        int tries = 0;
        user = "admin";
        pass = "admin";
        do{
            messageOut("\nEnter your username: ");
            username = sc.nextLine();
            messageOut("Enter your password: ");
            password = sc.nextLine();
            if(username.equals(user) && password.equals(pass))
            {
                messageOut(colors[1] + "You are logged in." + colors[0] + "\n\nDo you want to change username and password? \nType yes/no: ");
                change = sc.nextLine();
                if(change.equals("yes"))
                {
                    changeUserAndPass();
                }
                else
                {
                    messageOut(colors[1] + "You are logged out.\n" + colors[0]);
                }
                tries = 0;
            }
            else
            {
                messageOut(colors[3] + "Wrong username or password\n\n" + colors[0]);
                tries++;
            }
        }while(tries < 3);
        if(tries == 3){
            messageOut(colors[3] + "The number of tries has been exceeded"+ colors[0]);
        }
        sc.close();
    }
    public static void messageOut(String textLine)
    {
        System.out.print(textLine);
    }
    public static void changeUserAndPass()
    {
        messageOut(colors[2] + "\nEnter your new username: " + colors[0]);
        user = sc.nextLine();
        messageOut(colors[2] + "Enter your new password: "+ colors[0]);
        pass = sc.nextLine();
    }
}