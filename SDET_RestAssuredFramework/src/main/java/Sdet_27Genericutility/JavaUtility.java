package Sdet_27Genericutility;

import java.util.Random;

/**
 * The class contains java specific generic methods
 * @author DELL
 *
 */
public class JavaUtility {
/**
 * This method will generate random value for run
 * @return
 */
     public int getRandomNumber() {
		 
    	         Random ran = new Random();
    	        int randomNumber = ran.nextInt();
				return randomNumber;
    	        
    	        
    	 
     }
}
