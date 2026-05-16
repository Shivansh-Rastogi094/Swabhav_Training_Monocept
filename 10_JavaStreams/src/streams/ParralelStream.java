package streams;

import java.util.List;
import java.util.stream.Stream;

public class ParralelStream {
	private static long factorial(int n) {
	    long fact = 1;
	    for (int i = 1; i <= n; i++) {
	        fact *= i;
	    }
	    return fact;
	}
	
	public static void main(String[] args) {
		
		
	long startTime = System.currentTimeMillis();
	List<Integer> list = Stream.iterate(1, x->x+1).limit(1000).toList();
//	System.out.println(list);
	List<Long> factList = list.stream().map(x->factorial(x)).toList();
	long endTime = System.currentTimeMillis();
	System.out.println("Time Take in streams :"+(endTime-startTime)+"ms");

	
	 long newstartTime = System.currentTimeMillis();
	factList = list.parallelStream().map(x->factorial(x)).toList();
	 long newendTime = System.currentTimeMillis();
	System.out.println("Time Take in Parallel streams :"+(newendTime-newstartTime)+"ms");
	
	
	
	
	}
}
