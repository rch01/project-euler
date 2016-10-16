package projecteuler;

import java.util.List;
import java.util.ArrayList;

class Problem2
{
     public static void main(String []args)
	 {
         List<Integer> fibSeq = new ArrayList<Integer>();
         fibSeq.add(0,1);
         fibSeq.add(1,2);
         for(int i = 2;i < 32;i++)
         {
             fibSeq.add(fibSeq.get(i-2) + fibSeq.get(i-1));
         }
         System.out.println(fibSeq);
		 
		 int sumFibSeq = 0;
		 for(int i = 0;i < fibSeq.size();i++)
		 {
			 if((fibSeq.get(i) % 2) == 0)
			 {
				sumFibSeq += fibSeq.get(i);
			 }
		 }
		 System.out.println("\nSum of even Fibonacci nums: " + sumFibSeq);
     }
}

//fibSeq.get(i) = fibSeq.get(i-1) + fibSeq.get(i - 2);