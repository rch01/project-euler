package projecteuler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

/*
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 * The 50-digit numbers are saved in a .txt file, from where they will be read, line by line.
 */

public class Problem13 {
	public static void main(String [] args){
		new Problem13().largeSum();
	}
	
	void largeSum(){
		// Open the file
		FileReader fileInStream = null;
		try {
			fileInStream = new FileReader("src/projecteuler/Problem13.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fileInStream);

		String line;
		BigInteger sum = new BigInteger("0");
		
		//Read File Line By Line
		try {
			//int lineCount = 1;
			while ((line = br.readLine()) != null){
				sum = sum.add(new BigInteger(line));
				//System.out.println(lineCount+": "+line);
				//lineCount++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Close the input stream
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("First ten digits of the sum: "+sum.toString().substring(0, 10));
	}
}
