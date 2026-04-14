package learningTheards;

public class Testing extends Thread{
	
	 private String orderId;
	   Testing(String orderId) {
	        this.orderId = orderId;
	    }
	
	   public void run() {
	        System.out.println("Processing " + orderId + " by " + Thread.currentThread().getName());
	    }
	   
	   
	   
	   int pizza = 5;

	    public synchronized void orderPizza(String orderId) {
	        if (pizza > 0) {
	            System.out.println(orderId + " is ordering pizza...");
	            pizza--;
	            System.out.println("Remaining pizzas: " + pizza);
	        } else {
	            System.out.println(orderId + " failed: Out of stock");
	        }
	    }
	
	public static void main (String[] args) {
		
		Testing t1 = new Testing("Order-1");
		Testing t2 = new Testing("Order-2");
		
//		t1.start();
//		t2.start();
//		
		t1.orderPizza("Order-1");
		
	}
}
