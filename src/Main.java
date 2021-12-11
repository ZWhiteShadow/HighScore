import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter in names and scores of players to see high score list: \n");
        Scanner reader = new Scanner(System.in);

        System.out.print("How many people? ");
        int numberOfPlayers = reader.nextInt(); // ask for input on number of players
        System.out.println();

        int[] scoresArray = new int[numberOfPlayers]; // initialize array with length of number of players
        String[] unsortedPlayersArray = new String[numberOfPlayers];
        
        for (int player = 0; player < numberOfPlayers; player++) {

            System.out.println("Player " + (player + 1) + " of " + numberOfPlayers + ": ");

            System.out.print("Name: ");
            unsortedPlayersArray[player] = reader.next(); //ask for input for name

            System.out.print("Score: ");
            scoresArray[player]= reader.nextInt(); // ask for input for score

            System.out.println();
        }

        reader.close();

        int[] unsortedScoresArray = scoresArray.clone(); //Keep a copy of the original using clone otherwise would change with sort
        Arrays.sort(scoresArray); // change original array and sort in order - lowest to highest
        int[] newScoresArray = scoresArray.clone(); //Created due to duplicates

        String[] sortedPlayerArray = new String[numberOfPlayers];

        for (int i = 0; i < numberOfPlayers; i++) {
            for (int j = 0; j < numberOfPlayers; j++) {
                if (unsortedScoresArray[i] == scoresArray[j]) {
                    sortedPlayerArray[j] = unsortedPlayersArray[i]; // assign player name to empty array
                    unsortedScoresArray[i] = -1;  //solves duplicate issues
                    scoresArray[j] = -2; //solves duplicate issues
                }
            }
        }

        System.out.println("High Score List: ");
        int scoreRank = 0;

        for (int player = numberOfPlayers - 1; player >= 0; player--) {
            scoreRank++;
            System.out.println(scoreRank + ": " + sortedPlayerArray[player] + " " + newScoresArray[player]);

            //If a players score is the same as the next players score don't count up
            // for instance 1st wade 500, 2nd  max 300  2nd bob 300 3rd fred 100
            //Like olympics if there is a tie then both people get that ranking

            try {
                if ((newScoresArray[player] == newScoresArray[player - 1])) {
                    scoreRank--;
                }
            } catch (Exception e) {
                //
            }
        }

    }

}
