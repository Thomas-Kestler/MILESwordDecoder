//Thomas Kestler CS310
import java.util.*;
public class Decoder {

	public static  Queue Decode(Queue codes, ArrayList<Integer> pat) {
		int noise_index=0;//a value 6 or less is good: max of 1 noise. 7 or more means too noisy: 2 or more noise bits
		int pat_index = 0;//keeps track of the code of the pattern we are currently testing
		codes.normalize(); //makes it easier to compare patterns
		
		int count=0; //increments when we continue pattern, up to 6
		
		Queue queue_out = new Queue();
	
		
		while(!codes.isEmpty()) {
		int[] currArr = codes.peek(7);//get the next 7 values to check for a miles word
		for(int i=0;i<currArr.length;i++) {
			for(int k=0;k<pat.size();k+=7) {//this loop defines the current pattern to compare with the array of values
			if(currArr[i]==pat.get(k+i)) {//we can do this because the queue is normalized
				count++;
			}
			noise_index = i;
			pat_index = k+7;
			}
		}
		
		
		
	
		
		
		//word found
		if(count >=6 && noise_index<=6) {
			//put code found into queue_out
			for(int i=0;i<noise_index;i++){
				codes.nextValue();
			}
			queue_out.loadValue(pat.get(pat_index));//index of pat for the weapon code, the 7th current value
		}
		else //either not enough matches were found or the word was too noisy
		{
			for(int i=0;i<noise_index;i++){
				codes.nextValue();
			}
		}
		count=0; //reset count before looking at next segment of values
		codes.normalize();
		}
		
		return queue_out;
	}
	
	
}
