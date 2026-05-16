package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class StreamIntermediateOps {

	public static void main(String[] args) {
		// intermediate ops transform stream into another stream
		// they are lazy = they don't execute until we do a terminal op
		
		// 1. Filter = uses Predicate
		List<String> names = Arrays.asList("Ram","Raju","Rajesh");
		Stream<String> filteredStream = names.stream().filter(x->x.startsWith("R"));
		// untill we perform a terminal operation, it will not execute
		
		// 2. Map - Uses  Function
		Stream<String> name = names.stream().map(x->x.toLowerCase());
		Stream<String> name2 = names.stream().map(String::toLowerCase);
		System.out.println(name); // Look it doesnt print the actual answer because of no terminal op
	
		//3. Sorted = will sort the stream in natural order
		
		names.stream().sorted();
		
		// 4. Distinct = to return unique values
		
		names.stream().filter(x->x.startsWith("R")).distinct();
		
		// 5. Limit = to get a limited number of output
		
		System.out.println(Stream.iterate(1, x->x+1).limit(6).count());
		
		// 6. skip = to skip stating n elements | also depends on where have we placed the operation
		
		System.out.println(Stream.iterate(1, x->x+1).limit(6).skip(5).count());  // output 1
		System.out.println(Stream.iterate(1, x->x+1).skip(5).limit(6).count());  // output 6 
		
	
		
	} // main
} // class
