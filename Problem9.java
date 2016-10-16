package projecteuler;

/*
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */

class Problem9{
	public static void main(String [] args){
		//new Problem9().euclidFormula(36);
		new Problem9().bruteForce(36);
	}
	
	void euclidFormula(int total){
		int a = 0, b = 0, c = 0, m = 0, n = 0, k = 0;
		int upperBound = total / 2;
		boolean found = false;
		
		for(m = 1;m < Math.sqrt(upperBound);m++){
			n = (upperBound - m*m) / m;
			
			if(n >= m || (upperBound - m*m) % m > 0){
				continue;
			}
			else{
				a = m*m - n*n;
				b = 2*m*n;
				c = m*m + n*n;
				k = upperBound / (m*m + m*n);
				
				int sum = a + b + c;
				
				if(a*a + b*b == c*c && sum == total){
					System.out.println("[m, n] = "+"["+m+", "+n+"]");
					System.out.println("["+a+", "+b+", "+c+"]");
					System.out.println("product = " + a*b*c);
					System.out.println("k: "+k);
					found = true;
				}
				else{
					continue;
				}
			}
			if(found == true){
				break;
			}
		}
		if (found == false) {
			System.out.println("no triple found.");
			System.out.println("[m, n] = "+"["+m+", "+n+"]");
			System.out.println("k: "+k);
		}
	}
	
	int gcd(int a, int b){
		if(a == 0){
			return b;
		}
		else if (b == 0) {
			return a;
		}
		else{
			return gcd(b, a % b);
		}
	}
	
	void bruteForce(int sum){
		int c = 0;
		
		for(int a = 1;a < sum/3;a++){
			for(int b = a+1;b < sum/2;b++){
				c = sum - b - a;
				if(isPythagoreanTriple(a, b, c)){
					System.out.println("["+a+", "+b+", "+c+"]");
					System.out.println("product = " + a*b*c);
					return;
				}
			}
		}
	}
	
	boolean isPythagoreanTriple(int a, int b, int c){
		if (a*a + b*b == c*c) {
			return true;
		}
		else{
			return false;
		}
	}
}