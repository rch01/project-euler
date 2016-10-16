package projecteuler;

/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */

public class Problem10{
	public static void main(String [] args){
		double startTime = System.nanoTime();
		
		new Problem10().sieveOfEratosthenesModified(2000000);
		//new Problem10().sumPrimesBruteForce(100);
		//new Problem10().sieveOfEratosthenes(2000000);
		
		double endTime = System.nanoTime();
		double difference = (endTime - startTime) / 1000000;
		System.out.println("Time taken: "+ difference);
	}
	
	//brute force takes way too long. calculate complexity of this function.
	void sumPrimesBruteForce(long n){
		//long [] primesBelowN = new long[(int) n];
		long sum = 0;
		
		for(long i = 2;i <= n;i++){
			if(isPrime(i)){
				sum += i;
			}
		}
		//System.out.println("List of primes below "+n+": "+primesBelowN);
		System.out.println("Sum of primes below "+n+": "+sum);
	}
	
	void sieveOfEratosthenes(int n){
		if(n <= 1){
			System.out.println("input should be greater than 1.");
			return;
		}
		
		//create boolean array. initially assume all integers are prime therefore mark indexes from 2-10 as true. boolean defaults to false therefore indexes 0 and 1 will be false.
		boolean [] isPrime = new boolean[n+1];
		for(int i = 2;i <= n;i++){
			isPrime[i] = true;
		}
		
		//System.out.println(Arrays.toString(isPrime));
		
		/*
		 * mark non-primes <= n using Sieve of Eratosthenes.
		 * i <= sqrt(n) because you do not need to go through every index. e.g. if n = 64 then you only need to go up to i = 8.
		 */
		for(int i = 2;i <= Math.sqrt(n);i++){
			if(isPrime[i]){
				for(int j = i;	i*j <= n;	j++){
					isPrime[i*j] = false;
				}
			}
		}
		
		long sum = 0;//variable of type long because type int results in overflow.
		
		for(int i = 2;i <= n;i++){
			if(isPrime[i]){
				sum += i;
			}
		}
		System.out.println("Sum of primes below "+n+": "+sum);
	}
	
	//trial division primality test
	boolean isPrime(long n){
		if(n <= 1){
			return false;
		}
		for(long i = 2;i < n;i++){
			if(n % i == 0){
				return false;
			}
		}
		return true;
	}
	
	void sieveOfEratosthenesModified(int n){
		if(n < 2){
			System.out.println("input should be greater than 1.");
			return;// nothing after this return statement is executed. method terminates here.
		}
		
		int sqRt = (int) Math.sqrt(n);
		
		//create boolean array. initially assume all integers are prime therefore mark indexes from 2 to n as true.
		//boolean defaults to false therefore indexes 0 and 1 will be false.
		boolean [] isPrime = new boolean[n+1];
		for(int i = 2;i <= n;i++){
			isPrime[i] = true;
		}
		
		// Special case for prime number 2:
	    for(int i = 4; i < isPrime.length; i += 2) {
	    	isPrime[i] = false;
	    }
	    
	    // Special case for prime number 5:
	    for(int i = 10; i < isPrime.length; i += 5) {
	    	isPrime[i] = false;
	    }
		
		/*
		 * mark non-primes <= n using Sieve of Eratosthenes.
		 * when marking multiples of prime numbers as false, start at (primeNumber squared) because multiples smaller than (primeNumber squared) will have already been marked as false.
		 * If (primeNumber squared) is greater than n, you can stop.
		 * i <= sqrt(n) because you do not need to go through every index. e.g. if n = 64 then you only need to go up to i = 8 as 8*8 == 64.
		 * This method only considers odd numbers.
		 */
		for(int i = 3;i <= sqRt;i += 2){
			if(isPrime[i]){
				//System.out.println("\nPrimeNumber[i]*[j]Integer = multiple to mark as false");
				for(int j = i;	i*j <= n;	j+=2){
				//	System.out.println(i+"*"+j+"=	"+i*j);
					isPrime[i*j] = false;
				}
			}
		}
		long sum = 0;//variable of type long because type int results in overflow.
		
		for(int i = 2;i <= n;i++){
			if(isPrime[i]){
				sum += i;
			}
		}
		
		System.out.println("\nSum of primes below "+n+": "+sum);
		//System.out.println(Arrays.toString(isPrime));
	}
}