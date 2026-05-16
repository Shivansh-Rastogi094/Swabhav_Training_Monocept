package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LazyEvaluationDemo {
public static void main(String[] args) {
	List<String> names = Arrays.asList("Anna", "Rebecca","Alice","Taylor","Scarlet");
	
	Stream<String>stream=names.stream().filter(x-> {
		System.out.println("Filtering:" + x);
		return x.length()>3;
	});
	
	System.out.println("Before Terminal");
	
	List<String> result = stream.toList();
	System.out.println("After Terminal");
	System.out.println(result);
}
}
