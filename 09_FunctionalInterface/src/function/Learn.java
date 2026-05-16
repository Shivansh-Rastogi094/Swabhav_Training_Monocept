package function;
import java.util.function.Function;
public class Learn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<Integer,Integer> doubleIt = x-> 2*x;
		System.out.println(doubleIt.apply(100));
		Function<Integer,Integer> tripleIt = x-> 3*x;
		doubleIt.andThen(tripleIt).apply(100);
		System.out.println(doubleIt.andThen(tripleIt).apply(100));
//		Function.identity()
//		identity.apply(5);
		
	}

}

