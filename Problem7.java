package projecteuler;

/*
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10001st prime number?
 */

public class Problem7 {
	public static void main(String [] args){
		final long N = 10001L;
		
		new Problem7().findPrimeNumbers(N);
	}
	
	public void findPrimeNumbers(long n){
		int counter = 0;
		
		System.out.println("Computing...");
		
		for(int i = 0;counter != n;i++){
			if(isPrime(i)){
				counter++;
				if(counter == n){
					System.out.println(n + " prime is: " + i);
				}
			}
		}
	}
	
	//find more efficient ways of finding prime numbers
	private static boolean isPrime(long n){
		if(n <= 1)
		{
			return false;
		}
		for(long i = 2;i < n;i++)
		{
			if(n % i == 0)
			{
				return false;
			}
		}
		return true;
	}
}
