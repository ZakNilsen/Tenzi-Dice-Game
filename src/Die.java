import java.util.Random;

/**
 * Die class will create, in this case, a six-sided die that will
 * be rolled and generate a random face value from 1-6 which will t
 * then be printed out as face value number of asterisks/stars.
 * @author zaknilsen
 *
 */
public class Die {
	
	// instance variables 
	/** Is integer value that will tell what value die is when rolled */
	private int faceValue;
	
	
	// constructors methods 
	public Die() {
		faceValue = 1;
	}
	
	//methods
	/**
	 * method is a getter that will return faceValue	
	 * @return will return integer of faceValue
	 */
	public int getFaceValue() {
		return faceValue;
	}
	/**
	 * Will generate new random faceValue from 1-6
	 * @return void
	 */
	public void roll() {
		Random generator = new Random();
		faceValue = generator.nextInt(6)+1;
	}
		
	/**
	 * Will convert faceValue into string of asterisks for user to see
	 * the current faceValue of that die
	 * @return will return faceValue number of asterisks as string
	 */
	@Override
	public String toString() {
		if (faceValue == 1) {
			return "*";
		} else if (faceValue == 2) {
			return "* *";
		} else if (faceValue == 3) {
				return "* * *";
		} else if (faceValue == 4) {
			return "* * * *";
		} else if (faceValue == 5) {
			return "* * * * *";
		} else {
			return "* * * * * *";
		}
	}
}
			
			
		
	
	
	
	
	
	


