package lambdaExpression_and_PreRequisites;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class basics {
	public static void main (String[] args) {
		
//		Lambda exp -> no name, return type and access modifier | just and arrow 
		//Thread T1 = new Thread(new Task()); // Normally we have to it this way wthout lambda exp
		Thread T2 = new Thread(()-> {System.out.println("Thread run");});
		T2.run();
	 

   
//class Task implements Runnable{
//	public void run() {
//		System.out.println("Thread run");	}
//}
// Before lambda we had to write an entire calss just to implement this runnable, which now is being donw via streams


MathOperation add = (a,b)-> a+b; 
MathOperation sub = (a,b)-> a-b; 


int res = add.operate(1,2);
//System.out.print(res);
	



// Applying all the functional interface at once - 

Predicate<Integer> predicate = x-> x%2==0;
Function<Integer, Integer> function = x-> x*x;
Consumer<Integer> consumer = (x)-> System.out.println(x);
Supplier<Integer> supplier = ()-> 100; 
if(predicate.test(supplier.get())) {
	consumer.accept(function.apply(supplier.get()));
}

// Bi-Function,predicate and consumer
 BiPredicate<Integer,Integer> isSumEven = (x,y) -> (x+y)%2==0;
 BiFunction<Integer,Integer,Integer> doubleSum = (x,y) -> (x+y)*2;
 BiConsumer<Integer,Integer> print2 =(x,y)-> {
	 System.out.println(x);
	 System.out.println(y);
 };
 
 
// Unary(extends Function) and Binary(extends BiFunction) operator 
 UnaryOperator<Integer> a= x-> x*x;
 BinaryOperator<Integer> b=(x,y)->(x+y)*2;

 
// Method Reference => Use method without invoking it is used in place of lambda experssion
  List<Integer> list = Arrays.asList(1,2,3);
  list.forEach(x->System.out.println(x)); // using regularly via lambda
  list.forEach(System.out::println); // using via reference- we have used :: to pass the entire print method 
 
//  Constructor Reference 
  List <String> names = Arrays.asList("Ram", "Raju", "Raghav");
  List<MobilePhone> collect = names.stream().map(x->new MobilePhone(x)).collect(Collectors.toList()); //by using stream we can convert any collection into a stream
  List<MobilePhone> MobilePhoneList = names.stream().map(MobilePhone::new).collect(Collectors.toList()); // now we have removed the lambda expression and using constructor reference
} // main
} // class 

class MobilePhone{
	String name;

	public MobilePhone(String name) {
		this.name = name;
	}
}
interface MathOperation {
	int operate(int a, int b);
	}