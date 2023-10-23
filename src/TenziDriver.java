import java.util.Scanner;
/**
 * The purpose of this class is to take in all the other classes
 * for the Tenzi game and run them all here. The class will also
 * take in the user input and then send that to Tenzi Game to be 
 * re rolled and ultimately keep playing until the game is completed
 * in which the time for game will be shown and then added to leaderboard
 * which will be displayed. The user will then be asked whether they want 
 * to play again in which if yes then game will restart and go on
 * until eventually user does not want to play again, in which the 
 * program will terminate.
 * @author zaknilsen
 *
 */
public class TenziDriver {

    public static void main(String[] args) {
	    Scanner keyboard = new Scanner(System.in);
	    Leaderboard times = new Leaderboard();
	    //initial roll
	    while (true) {
		    String continueGame;
		    String dieReroll; 
		    String time;
		    int[] rerolls;
		    long gameTime;
		    TenziGame game = new TenziGame();
		    System.out.println(game);
		 
            while (game.isOver() == false) {
                game.getTurns();
                System.out.println("Which to roll: ");
                dieReroll = keyboard.nextLine();
                rerolls =  splitToInts(dieReroll);
                game.roll(rerolls);
                System.out.println(game);
                	
            }
            gameTime = game.getTimeElapsed();
            times.update(gameTime);
            System.out.println("Game over." + "  Time is " + (gameTime/1000.0));
            //display leader board
            time = times.toString();
            System.out.println(time);
            
            System.out.println("Play again? (Y/N)");
            continueGame = keyboard.nextLine();
            if (continueGame.equals("Y")) {
                continue;
            } else {
                return;
            }
        }
    }
			
	/**
	 *The purpose of this method is to take in a string of integers
	 *that will be then split and added to a string array. Since we want
	 *to return an integer array we convert the string to an array in which
	 *will be sent to the die roll method in TenziGame class.
	 * @param dieReroll is string of integers that user sends in to tell
	 * which die they want re-rolled so that they can ultimately complete
	 * the game
	 * 
	 * @return returns integer array that will be sent to roll in TenziGame
	 * where specific die will be re-rolled
	 */
    public static int[] splitToInts(String dieReroll) {
        //add split to string array and convert to integer array
        String[] stringHolder = dieReroll.split(",");
        int[] userInts = new int[stringHolder.length];
        for (int i = 0; i < stringHolder.length; i++) {
            int intHolder = Integer.parseInt(stringHolder[i]);
            userInts[i] = intHolder;
        }
        return userInts;
    }
}
