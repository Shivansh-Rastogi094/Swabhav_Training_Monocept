package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
public static void main(String[] args) {
	// streams are used to process collections in a functional and decleartive manner
	// allows functional programming and easy parrellelism without the complexity of multithreading
	
	// How to use Streams
//	Source -> Intermidiate Operations -> Terminal Operation
	List<Integer> numbers = Arrays.asList(1,2,3,4,5);
	
	// before stream we had to write entire code for counting even numbers;
	int count=0;
	for(int i :numbers) {
		if(i%2==0) count++;
	}
	System.out.println(count);
	
	// Now via Stream, this could be done in 1 line of code
	System.out.println(numbers.stream().filter(x->x%2==0).count());
//	numbers.stream().filter(x->x%2==0).count();
	
	
	//Creating Steams
	//1. From Collections -> collection_name.stream()
	//2. from Array
	String[] names = {"Ram","Raju","Raghav"};
	Arrays.stream(names);
	//3. Using Stream.of()
	Stream<Integer>nums=Stream.of(1,2,3);
	//4. Infinite Streams
	Stream.generate(()-> 1);
	
}
}
