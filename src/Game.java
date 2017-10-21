import java.io.File;
import java.util.Scanner;

public class Game
{
    private static char[] guesses = new char[26];
    private static int numberOfTries = 0;
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

    static char getUserInput() {
            System.out.println("Your gues?....");
            Scanner userInputScanner = new Scanner(System.in);
            char input = userInputScanner.next().charAt(0);
            guesses[numberOfTries] = input;
            numberOfTries += 1;
            return input;
        }

    static int getPosition(String movie, char userChar){
        int charPosition = movie.indexOf(userChar);
        return charPosition;
    }

    static String getguessedLetters() {
        String guessesStr = new String(guesses);
        return guessesStr;
    }
}
