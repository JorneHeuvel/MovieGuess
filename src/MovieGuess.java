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

        System.out.println("I have chosen a movie try to guess it!");
        System.out.println(blankMovie);
        System.out.println(selectedMovie);

        for (int gamePoints = 10; gamePoints >= 0;) {
            if (gamePoints != 0){
                char userGuess = Game.getUserInput();
                boolean inTitle = Game.letterInTitle(selectedMovie, userGuess);
                int letterPosition[] = Game.getPositions(selectedMovie, userGuess);


                if (inTitle) {

                    for (int j = 0; j < letterPosition.length; j++){
                        if (letterPosition[j] != -1) {
                            answer[letterPosition[j]] = userGuess;
                        } else {
                            break;
                        }
                    }
                    System.out.println(answer);
                    if (answer.toString() == selectedMovie) {
                        System.out.println("CORRECT YOU WIN!!!");
                    }
                    System.out.println("You have guessed " + Game.getGuessedLetters());
                } else {
                    System.out.println("No such letter in title!");
                    System.out.println(answer);
                    gamePoints -= 1;
                    System.out.println(gamePoints + " guesses left!");
                    System.out.println("You have guessed " + Game.getGuessedLetters());
                }
            } else {
                System.out.println("YOU LOSE!!!");
                System.out.println("The movie was called : " + selectedMovie);
                break;
            }
        }
    }
}
