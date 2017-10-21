import java.io.File;
import java.util.Scanner;

public class Game
{
    static String[] makeArray(File file) throws Exception
    {
        Scanner fileScanner = new Scanner(file);
        String[] input = new String[50];
        for (int i = 0; fileScanner.hasNextLine(); i++) {
            input[i] = fileScanner.nextLine();
        }
        return input;
    }

    static String makeBlank(String movie){
        String blankMovie = "";
        for (int i = 0; i <= movie.length(); i++) {
            blankMovie += '_';
        }
        return blankMovie;
    }

    static boolean letterInTitle(String movie, char userChar){
        int charPosition = movie.indexOf(userChar);
        boolean inTitle;
        inTitle = charPosition != -1;
        return inTitle;
    }

    static char getUserInput(){
        System.out.println("Your gues?....");
        Scanner userInputScanner = new Scanner(System.in);
        char input = userInputScanner.next().charAt(0);
        return input;
    }

    static int getPosition(String movie, char userChar){
        int charPosition = movie.indexOf(userChar);
        return charPosition;
    }
}
