package projecteuler;

//A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
//Find the largest palindrome made from the product of two 3-digit numbers. - 906609

public class Problem4{
	public static void main(String[] args){
		testIsPalindromicNumber(1234);
		//palindromicProduct();
	}
	
	public static void palindromicProduct(){
		int digitOne = 0;
		int digitTwo = 0;
		int palindromicProduct = 0;
		for(int i = 100;i < 1000;i++){
			for(int j = 100;j < 1000;j++){
				if(isPalindromicNumber(i * j) && (i * j) > palindromicProduct){
					digitOne = i;
					digitTwo = j;
					palindromicProduct = i * j;
				}
			}
		}
		System.out.println("Largest palindrome made from the product of two 3-digit numbers: "+digitOne+" * "+digitTwo+" = "+palindromicProduct);
	}
	
	public static void testIsPalindromicNumber(int number){
		try{
			System.out.println("is "+number+" palindromic?\t"+isPalindromicNumber(number));
		}
		catch(NumberFormatException e){
			System.err.println(e+"is not an Integer.");
		}
	}
	
	//method checks if a number is palindromic using modulus to reverse the number. returns boolean true or false.
	public static boolean isPalindromicNumber(int number){
		int originalNumber = number;
		int reversedNumber = 0;
		int remainder = 0;
		
		while(number != 0){
			remainder = number % 10;
			number /= 10;
			reversedNumber = (reversedNumber * 10) + remainder;
		}
		//System.out.println("original number:\t"+originalNumber+"\nreversed number:\t"+reversedNumber);
		
		if(originalNumber == reversedNumber){
			return true;
		}
		else{
			return false;
		}
	}
}