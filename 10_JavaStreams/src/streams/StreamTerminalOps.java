package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTerminalOps {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1,2,3,4,5);
		Stream<Integer> nums1 = nums.stream();
		
		// 1. Collect 
		
		System.out.println(nums.stream().skip(1).collect(Collectors.toList()));
		System.out.println(nums.stream().skip(1).toList());
		
		// 2. forEach = works just like a for each loop
		
		// nums1.forEach(x-> System.out.print(x));
		
		// 3. reduce = combine elements to give a single result
		
		System.out.println(nums.stream().reduce((x,y)->x+y)); // it will return a Optional[] value
		Optional<Integer> optionalInt=nums1.reduce((x,y)->x+y);
		System.out.println(optionalInt.get());
		
		// 4. count
		
		// 5. anyMatch || allMatch || noneMatch
		
		System.out.println(nums.stream().anyMatch(x->x%2==0));
		System.out.println(nums.stream().allMatch(x->x%2==0));
		System.out.println(nums.stream().noneMatch(x->x>10));
		
		// 6. findFirst and findAny
	
		System.out.println(nums.stream().findFirst().get());
		System.out.println(nums.stream().findAny().get());
		
		
		// Examples
		
		List<String> names = Arrays.asList("Anna", "Rebecca","Alice","Taylor","Scarlet");
		
		System.out.println(names.stream().filter(x->x.length()>4).toList());
		
		// Example Squaring and sorting numbers
		
		List<Integer> xyz =Arrays.asList(5,1,4,3,2);
		
		System.out.println(xyz.stream().map(x->x*x).sorted().toList());
		
		
		// summing values
		
		System.out.println(xyz.stream().reduce((x,y)->(x+y)).get());
		
		// Occurance of a char
		
		String str ="Hello world";
		System.out.println(str.chars().filter(x->x=='o').count());
		
		
		// Stateless and Statefull - Ops which do not require the knowledge of all the other elemnets(map, count) are called stateless
		// where as, ops which require the knowledge of all the elements are called statefull (sorted, distinct)
		
		
	} // main
} // class
