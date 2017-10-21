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
        for (int i = 0; i <= movie.length()-1; i++) {
            blankMovie += '_';
        }
        return blankMovie;
    }

    static boolean letterInTitle(String movie, char userChar){
        int charPosition = movie.indexOf(userChar);
        if (charPosition != -1) {
             return true;
        } else
            return false;
        }


    static char getUserInput() {
            System.out.println("Your gues?....");
            Scanner userInputScanner = new Scanner(System.in);
            char input = userInputScanner.next().charAt(0);
            guesses[numberOfTries] = input;
            numberOfTries += 1;
            return input;
        }

    static int[] getPositions(String movie, char userChar){
        int[] charPosition = new int[movie.length()];
        for (int i = 0; i < movie.length();i++){
            if (movie.indexOf(userChar, i) != -1) {
                charPosition[i] = movie.indexOf(userChar, i);
            } else {
                charPosition[i] = -1;
                break;
            }
        }
        return charPosition;
    }

    static String getGuessedLetters() {
        String guessesStr = new String(guesses);
        return guessesStr;
    }
}
