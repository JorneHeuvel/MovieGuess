import java.io.File;
import java.util.Scanner;

public class MovieGuess {
    public static void main(String[] args) throws Exception {

        File file = new File("movies.txt");
        int randomNumber = (int) (Math.random() * 10 + 1);
        String[] movieArray = Game.makeArray(file);
        String selectedMovie = movieArray[randomNumber];
        String blankMovie = Game.makeBlank(movieArray[randomNumber]);
        char[] answer = blankMovie.toCharArray();

        System.out.println("I have chosen a movie try to quess it!");
        System.out.println(blankMovie);

        for (int gamePoints = 10; gamePoints >= 0;) {
            if (gamePoints != 0){
            char userGuess = Game.getUserInput();
            boolean inTitle = Game.letterInTitle(selectedMovie, userGuess);
            int letterPosition = Game.getPosition(selectedMovie, userGuess);

            if (inTitle) {
                System.out.println("Found letter at position : " + letterPosition + "!");
                answer[letterPosition] = userGuess;
                System.out.println(answer);

            } else {
                System.out.println("No such letter in title!");
                System.out.println(answer);
                gamePoints -= 1;
                System.out.println(gamePoints + " guesses left!");
            }
        } else {
                System.out.println("YOU LOSE!!!");
                System.out.println("The movie was called : " + selectedMovie);
                break;
            }
    }
}}
