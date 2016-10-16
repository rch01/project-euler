package projecteuler;

public class Problem15 {
	public static void main(String [] args){
		double startTime = System.nanoTime();
		
		new Problem15().latticePathsPascalTriangle(20);
				
		double endTime = System.nanoTime();
		double difference = (endTime - startTime) / 1000000;
		System.out.println("\nrunning time in milliseconds: "+difference);
		
		//System.out.println(new Problem15().factorialRecursive(21));
		//System.out.println(new Problem15().factorialModified(0));
	}
	
	/* dynamic programming solution (memoization) based on Pascal's triangle (triangular array of the binomial coefficients) - this function computes total number of lattice paths in a grid by computing Pascal's triangle.
	 * A simple construction of the triangle proceeds as follows: in row 0 the entry is (0,0) = 1.
	 * Then, to construct the elements of the following rows, sum the two values directly above and directly to the left, to find the new value to place in that position. * If either the number to the right or left not present, substitute zero in its place.
	 * */
	void latticePathsPascalTriangle(int gridSize){
		long [][] grid = new long [gridSize + 1][gridSize + 1];//add one to grid size to accurately represent how many nodes are in a lattice path grid - e.g. a 2x2 grid has 9 nodes total and therefore the size of a 2D array would have to be 3x3.
		//grid[0][0] = 1;
		
		for(int row = 0;row < grid.length;row++){//goes through array row by row.
			for(int col = 0;col < grid.length;col++){
				grid[row][col] = (row == 0 || col == 0) ? 1 : grid[row - 1][col] + grid[row][col - 1];//replaced the if/else statement below with conditional expression using ternary operator ?: .
				
//				if(row == 0 || col == 0){
//					grid[row][col] = 1;
//				}
//				else{
//					grid[row][col] = grid[row - 1][col] + grid[row][col - 1];
//				}
			}
		}
		System.out.println("number of lattice paths in a "+ gridSize + "x"+ gridSize + " grid: " + grid[gridSize][gridSize]);
	}
	
	void latticePathsMultiplicativeBinomialCoefficients(){
		
	}
	
	//modified version of latticePathsPascalTriangle function to use for loop instead of ternary expression to see which one is quicker. no difference between the two.
	void latticePathsMemoizationModified(int gridSize){
		long [][] grid = new long [gridSize + 1][gridSize + 1];
		
		for(int i = 0;i < grid.length;i++){//for loop to fill first row and first column with 1, as per Pascal's triangle -- for loop is used instead of if statement.
			grid[0][i] = 1;
			grid[i][0] = 1;
		}
		
		for(int row = 1;row < grid.length;row++){
			for(int col = 1;col < grid.length;col++){
				grid[row][col] = grid[row - 1][col] + grid[row][col - 1];
			}
		}
		System.out.println("number of lattice paths in a "+ gridSize + "x"+ gridSize + " grid: " + grid[gridSize][gridSize]);
	}
	
	//naive implementation of binomial coefficient algorithm cannot handle numbers above 20 unless BigInteger is used - use the binomial coefficient multiplicative algorithm instead.
	void binomialCoefficient(long n, long k){
		long numberOfCombinations = factorialModified(n) / (factorialModified(k) * factorialModified(n - k));
		System.out.println(numberOfCombinations);
	}
	
	// return n!
    // precondition: n >= 0 and n <= 20
	long factorialRecursive(long n){
		if(n < 1){	return 1;	}
		
		else if(n > 20){	throw new RuntimeException("Overflow error in factorial function. Input is greater than 20.");	}
		
		else{	return n * factorialRecursive(n - 1);	}
	}
	
	//non-recursive factorial
	long factorialModified(long n){
		long factorialValue = 1;
		
		while(n > 1){
			factorialValue *= n;
			n--;
		}
		
		return factorialValue;
	}
}
