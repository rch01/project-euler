package projecteuler;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

/*
 * The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
 */

public class Problem14 {
	public static void main(String [] args){
		double startTime = System.nanoTime();

		new Problem14().longestCollatzSequenceMemoization(1000000);
		//new Problem14().longestCollatzSequence(1000000);
		//new Problem14().collatzSequence(3);
		//new Problem14().collatzSequence(9);

		double endTime = System.nanoTime();
		double difference = (endTime - startTime) / 1000000;
		System.out.println("\nrunning time in milliseconds: "+difference);
	}
	
	void longestCollatzSequence(long startingNumber){
		int numberOfTerms = 0;
		int countTerms = 0;
		long startingNumberWithLongestSequence = 0;
		
		//for loop for starting number
		for(int i = 2;i <= startingNumber;i++){
			long number = i;
			countTerms = 1;//starting at one to include the starting number in the total number of terms
			
			//while loop for each term of the collatz sequence
			while(number != 1){
				if(number % 2 == 0){
					number /= 2;
					countTerms++;
				}
				else{
					number = 3*number + 1;
					countTerms++;
				}
			}
			
			if(countTerms > numberOfTerms){
				numberOfTerms = countTerms;
				startingNumberWithLongestSequence = i;
			}
		}
		System.out.println("\n"+startingNumberWithLongestSequence);
		System.out.println("number of terms in Collatz Sequence: "+numberOfTerms);
	}
	
	void longestCollatzSequenceMemoization(long startingNumber){
		if(startingNumber < 1){
			System.out.println("Use natural numbers >= 1 for the Collatz Sequence.");
			return;
		}
		
		long [] cache = new long [(int) (startingNumber + 1)];//array used as cache for memoization technique. Add one to the size of the array to ensure each index of the array is a starting number (indexes go from 1 to startingNumber).
		int numberOfTerms = 0;
		long startingNumberWithLongestSequence = 0;
		
		//fill/initialise the cache array with zeros.
		for(int i = 0;i < cache.length;i++){
			cache[i] = 0;
		}
		cache[1] = 1;//starting number 1 has 1 term in its Collatz Sequence.
		
		//for loop to go through all starting numbers, starting at 2.
		for(int i = 1;i <= startingNumber;i++){
			long term = i;//variable 'term' holds the current term of the sequence, while variable 'i' is the starting number.
			int countTerm = 0;//counts all the terms in a Collatz sequence. The starting number is also a term that needs to be included in the total count of terms in a Collatz Sequence.
			
			//while loop for collatz sequence of starting number
			//while loop continues until variable term (the current term) is equal to 1 AND is less than the starting number (i).
			while(term != 1 && term >= i){
				countTerm++;//Beginning with the starting number, if a term passes the checks of the while loop, count it.
				if(term % 2 == 0){
					term /= 2;
				}
				else{
					term = term * 3 + 1;
				}
			}
			
			//store starting number and number of terms in cache - 'starting number' is used as the index and 'number of terms' is the element for that index.
			cache[i] = countTerm + cache[(int) term];
			
			if(cache[i] > numberOfTerms){
				numberOfTerms = (int) cache[i];
				startingNumberWithLongestSequence = i;
			}
		}
		System.out.println("\nstarting number with longest chain: "+startingNumberWithLongestSequence);
		System.out.println("number of terms in Collatz Sequence: "+numberOfTerms);
		//System.out.println(Arrays.toString(cache));
	}
	
	//computes the Collatz Sequence for a starting number
	void collatzSequence(long startingNumber){
		if(startingNumber < 1){
			System.out.println("Use natural numbers >= 1 for the Collatz Sequence.");
			return;
		}
		
		List<Long> collatzSequence = new ArrayList<Long>();
		collatzSequence.add(startingNumber);
		
		//while loop for collatz sequence
		while(startingNumber != 1){
			if(startingNumber % 2 == 0){
				startingNumber /= 2;
				collatzSequence.add(startingNumber);
			}
			else{
				startingNumber = 3*startingNumber + 1;
				collatzSequence.add(startingNumber);
			}
		}
		System.out.println("\n"+collatzSequence);
		System.out.println("number of terms: "+ collatzSequence.size());
	}
}
