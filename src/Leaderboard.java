import java.util.ArrayList;
import java.util.Collections;
/**
 * The Leaderboard class takes in users times of games they have 
 * completed and will show the top 3 in the proper order, as it
 * constantly updates the ArrayList with new times.
 * @author zaknilsen
 *
 */
public class Leaderboard {
	//initializers
	/** will take in the times from users completed Tenzi games */
    private ArrayList<Long> bestTimes;
	
	//constructors
    public Leaderboard() {
        bestTimes = new ArrayList<Long>();
    }
	//methods
	/**
	 * This method takes in a long integer of time and then updates 
	 * the ArrayList of bestTimes and sorts it from best to worst of 
	 * completed Tenzi games that user has played.
	 * @param time will take in a long integer of time that
	 * will be sorted and added into ArrayList from best time
	 * to worst
	 * @return void
	 */
    public void update(long time) {
		bestTimes.add(time);
		Collections.sort(bestTimes);

    }
    /**
     * this will display the leader board of users times, limiting 
     * the display to only the 3 best times from best to worst.
     * @return will return String of best times in the proper order
     */
    @Override
    public String toString() {
		//do conversion from milliseconds to seconds here
        String leaderboard  = "--Current Leaderboard (in seconds)--\n";
        String leaderboardMessage = "--Current Leaderboard (in seconds)--\n";
        for (int i = 0;  i < bestTimes.size(); i++) {
            if (bestTimes.size() > 3) {
                return leaderboardMessage +(bestTimes.get(0)/1000.0) + "\n" + (bestTimes.get(1)/1000.0) + "\n" + (bestTimes.get(2)/1000.0) +"\n" ;
            } else {
                leaderboard = leaderboard + (bestTimes.get(i)/1000.0)+ "\n";
            }
        }
        return leaderboard;
    }
}
