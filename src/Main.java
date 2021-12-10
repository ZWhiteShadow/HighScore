import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

////        --Comment this out to test -- START -- //

        System.out.println("Enter in names and scores of players to see high score list: \n");
        Scanner reader = new Scanner(System.in);

        System.out.print("How many people? ");
        int numberOfPlayers = reader.nextInt();
        System.out.println();

        int[] scoresArray = new int[numberOfPlayers];
        String[] unsortedPlayersArray = new String[numberOfPlayers];

        for (int player = 0; player < numberOfPlayers; player++) {


                System.out.println("Player " + (player + 1) + " of " + numberOfPlayers + ": ");

                System.out.print("Name: ");
                String name = reader.next();
                unsortedPlayersArray[player] = name;

                System.out.print("Score: ");
                int score = reader.nextInt();
                scoresArray[player] = score;

                System.out.println();
            }

        }

        reader.close();

//--Comment this out to test -- END -- //

//        // -- Used For Testing -- //
//        int numberOfPlayers = 9;
//        int[] scoresArray = {                 7332,         1,       654,        37,    100000,       754,      9874,         0,       5000};
//        String[] unsortedPlayersArray = {"Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9",};
//        //-

//        // -- Used For Testing -- //
//        int numberOfPlayers = 4;
//        int[] scoresArray = {                   39,        38,        38,        37};
//        String[] unsortedPlayersArray = {    "Bob",    "Wade",     "Max",  "Marry"};
//        //-


        int[] unsortedScoresArray = scoresArray.clone();
        Arrays.sort(scoresArray);
        int[] newScoresArray = scoresArray.clone(); //Created due to duplicates

        String[] sortedPlayerArray = new String[numberOfPlayers];

        for (int i = 0; i < numberOfPlayers; i++) {
            for (int j = 0; j < numberOfPlayers; j++) {
                if ( unsortedScoresArray[i] == scoresArray[j] ) {
                    sortedPlayerArray[j] = unsortedPlayersArray[i];
                    unsortedScoresArray[i] = -1;  //solves duplicate issues
                    scoresArray[j] = -2; //solves duplicate issues
                }
            }
        }

        System.out.println("High Score List: ");
        int scoreRank = 0;

        for (int player = numberOfPlayers - 1; player >=0; player--){
            scoreRank++;
            System.out.println(scoreRank + ": " + sortedPlayerArray[player] + " " + newScoresArray[player]);

            //If a player next player is the same don't count up
            try {
                if ( (newScoresArray[player] == newScoresArray[player - 1] ) ) {
                    scoreRank--;
                }
            }
            catch(Exception e) {

            }
    }

}


}
