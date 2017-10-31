import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Game
{
    private static char[] guesses = new char[26];
    private static int numberOfTries = 0;
    private static String blankMovieStr = "";
    private static int gamePoints = 10;
    private static boolean equals = false;


    static String[] makeArray(File file) throws Exception
    {
        Scanner fileScanner = new Scanner(file);
        String[] input = new String[50];
        for (int i = 0; fileScanner.hasNextLine(); i++) {
            input[i] = fileScanner.nextLine();
        }
        return input;
    }

    static String selectMovie(String[] movieArray){
        int randomNumber = (int) (Math.random() * 10 + 1);
        return movieArray[randomNumber];
    }

    static String makeBlank(String movie){
        for (int i = 0; i <= movie.length()-1; i++) {
                blankMovieStr += '_';
            }
        return blankMovieStr;
    }

    static int getGamepoints(){
        return gamePoints;
    }

    static void decreaseGamePoints(int value){
        gamePoints = gamePoints - value;
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

    static boolean arraysMatch(char[] answer, String selected){
        char[] selectedArray = selected.toCharArray();
        if (Arrays.equals(answer, selectedArray)) {
            equals = true;
        }
        return equals;
    }

}
