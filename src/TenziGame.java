import java.util.ArrayList;
/**
 * This class takes in all the important game functions so that the game
 * can function properly and work as intended. Makes sure game ends 
 * when it is supposed to, that die values are stored and re-rolled
 * also keeps track of time which is eventually sent to leaderboard. 
 * Also has important function of printing proper die values into
 * the console so that the user knows what value the die have.
 * @author zaknilsen
 *
 */
public class TenziGame {
	//initializers
	/** integer to keep track of turns taken in one game */
	private int turns;
	/** start of timer when game begins */
	private long startTime;
	/** end of timer when game is over */
	private long endTime;
	/**ArrayList to hold the die values */
	private ArrayList<Die> theDice;
	//constructors
	public TenziGame() { 
	    startTime = System.currentTimeMillis();
	    turns = 0;
	    
	    theDice = new ArrayList<Die>();	
	    for (int i = 0; i < 10; i++) {
	        Die die =  new Die();
	        die.roll();
	        theDice.add(die);
	    }
	}
	//methods
    /**
     * Determines if game is over, or if it continues
     * @return boolean true or false
     */
    public boolean isOver() {
        for (int i = 0; i < theDice.size()-1; i++) {
            int faceValue = theDice.get(i).getFaceValue();
            if (faceValue != theDice.get(i+1).getFaceValue()) {
                return false;
            }
        }
        return true;
    }
        
	/**
	 * takes in integer array from splitToInts and re-rolls the
	 * die at the values specified
	 * @param rerolls integer array sent from splitToInts that 
	 * specify values that user wants re-rolled
	 */
    public void roll(int[] rerolls) {
        for (int i = 0;  i < rerolls.length;  i++)  {
            int spotToReroll = rerolls[i];
            Die reroll = theDice.get(spotToReroll);
            reroll.roll();
            theDice.set(spotToReroll, reroll);
        }
    }
    /**
     * determines overall end time when game is completed
     * @return returns long integer of final time
     */
    public long getTimeElapsed() {
        endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    /**
     * calculates total number of turns
     * @return returns total number of turns in integer form
     */
    public int getTurns() {
        turns = turns + 1;
        return turns;	
    }
    /**
     * prints out die for user to see in friendly and understandable
     * format
     * @return string of die that user will be able to see
     */
    @Override
    public String toString() {
        String dieString = "";
        for (int i = 0; i < theDice.size(); i++) {
            dieString = dieString + i + ":" + theDice.get(i) + "\n";
        }
        return dieString;
    }
}
