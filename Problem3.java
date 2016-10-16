package projecteuler;
import java.util.List;
import java.util.ArrayList;

class Problem3{
	static List<Long> primeFactors = new ArrayList<Long>();
	
	public static void main(String[] args){
		//testIsPrime(600851475143L);
		PrimeFactorisation(232792560);
	}
	
	public static void PrimeFactorisation(long number){
		//What is the largest prime factor of the number 600851475143/59846371937L/1319560085147514357L ?
		if(isPrime(number))
		{
			System.err.println(number + " is a prime number. Therefore, no prime factors.");
		}
		else
		{
			long originalNumber = number;
			long divisor = 2;
			while(number != 1)
			{
				if(number % divisor == 0)
				{
					number /= divisor;
					primeFactors.add(divisor);
				}
				else
				{
					divisor++;
				}
			}
			System.out.println("Prime Factors of "+originalNumber+": " + primeFactors);
		}
	}
	
	public static void testIsPrime(long number){
		System.out.println("is "+number+" a prime number? "+isPrime(number));
	}
	
	public static boolean isPrime(long n){
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