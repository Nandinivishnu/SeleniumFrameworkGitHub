package generic_utility;

import java.util.Random;

public class Java_Utility {

	/**
	 * 
	 * 
	 * this method is used to avoid duplicates
	 * @return RanNum
	 *@author nandini
	 * 
	 * 
	 * */
	
	
	
	
	public int getRandomNum() {
		Random ran = new Random();
		int RanNum = ran.nextInt(1000);
		return RanNum;
	}

}
