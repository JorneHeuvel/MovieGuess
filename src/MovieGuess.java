import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class MovieGuess {
    public static void main(String[] args) throws Exception {

        //select a file with movie titles
        File file = new File("movies.txt");

        //create an array from file
        String[] movieArray = Game.makeArray(file);

        //select a random movie
        String selectedMovie = Game.selectMovie(Game.makeArray(file));

        //make a displayed movie blank
        String blankMovie = Game.makeBlank(selectedMovie);

        //make selected movie title into an array
        char[] answer = blankMovie.toCharArray();

        //Display user instructions
        System.out.println("I have chosen a movie try to guess it!");

        //get and set spaces
        int spacePositions[] = Game.getPositions(selectedMovie, ' ');
        for (int i = 0; i < spacePositions.length; i++) {
            if (spacePositions[i] != -1) {
                answer[spacePositions[i]] = ' ';
            } else {
                break;
            }
        }
        System.out.println(answer);

        //Program
        int gamePoints = Game.getGamepoints();
        for (gamePoints = 10; gamePoints >= 0; ) {
            gamePoints = Game.getGamepoints();
            boolean test = Arrays.equals(answer,selectedMovie.toCharArray());
            if (gamePoints != 0 || test != true) {
                test = Arrays.equals(answer,selectedMovie.toCharArray());
                char userGuess = Game.getUserInput();
                boolean inTitle = Game.letterInTitle(selectedMovie, userGuess);
                int letterPosition[] = Game.getPositions(selectedMovie, userGuess);

                System.out.println(test);
                if (inTitle) {
                    //Letter in title
                        for (int j = 0; j <= letterPosition.length-1; j++) {
                            if (letterPosition[j] != -1) {
                                answer[letterPosition[j]] = userGuess;
                            } else {
                                break;
                            }
                        }
                        System.out.println("Correct!");
                        System.out.println(answer);
                        System.out.println("You have guessed " + Game.getGuessedLetters());
                        test = Arrays.equals(answer, selectedMovie.toCharArray());
                        if (test) {
                            System.out.println("CORRECT YOU WIN!!!");
                            break; }
                            else {

                        //Letter not in title
                        System.out.println("No such letter in title!");
                        System.out.println(answer);
                        Game.decreaseGamePoints(1);
                        System.out.println(Game.getGamepoints() + " guesses left!");
                        System.out.println("You have guessed " + Game.getGuessedLetters());
                    }
                }
            } else {
                //No more guesses so a LOSS
                System.out.println("YOU LOSE!!!");
                System.out.println("The movie was called : " + selectedMovie);
                break;
            }
        }
    }
}