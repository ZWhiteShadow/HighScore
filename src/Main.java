import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter in names and scores of players to see high score list: \n");
        Scanner reader = new Scanner(System.in);

        System.out.print("How many people? ");
        int numberOfPlayers = reader.nextInt();
        System.out.println();

        int[] scoresArray = new int[numberOfPlayers];
        String[] playersArray = new String[numberOfPlayers];

        for (int player = 0; player < numberOfPlayers; player++) {

            System.out.println("Player " + (player + 1) + " of " + numberOfPlayers + ": ");

            System.out.print("Name: ");
            String name = reader.next();
            playersArray[player] = name;

            System.out.print("Score: ");
            int score = reader.nextInt();
            scoresArray[player] = score;

            System.out.println();

        }

        reader.close();

        int[] unsortedScoresArray = scoresArray.clone();
        Arrays.sort(scoresArray);

        String[] sortedPlayerArray =  new String[playersArray.length];

        for (int i = 0; i < scoresArray.length; i++){
            sortedPlayerArray[i] = playersArray[findIndex(scoresArray,unsortedScoresArray[i])];
        }

        System.out.println("High Score List: ");
        int scoreRank = 0;
        for (int player = numberOfPlayers - 1; player >= 0 ; player--) {
            scoreRank++;
            System.out.println( scoreRank + ": " + sortedPlayerArray[player] + " " + scoresArray[player]);
        }

    }
    public static int findIndex(int[] arr, int t) // https://www.geeksforgeeks.org/find-the-index-of-an-array-element-in-java/
    {
        int index = Arrays.binarySearch(arr, t);
        return (index < 0) ? -1 : index;
    }

}
