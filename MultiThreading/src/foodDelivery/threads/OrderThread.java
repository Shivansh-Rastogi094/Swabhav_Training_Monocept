package foodDelivery.threads;


	import foodDelivery.model.Order;
	import foodDelivery.service.*;

	public class OrderThread extends Thread {
	    private Order order;
	    private Inventory inventory;
	    private DeliveryAgentManager agentManager;
	    private PaymentService paymentService;

	    public OrderThread(Order order, Inventory inventory,
	                       DeliveryAgentManager agentManager,
	                       PaymentService paymentService) {
	        this.order = order;
	        this.inventory = inventory;
	        this.agentManager = agentManager;
	        this.paymentService = paymentService;
	    }

	    @Override
	    public void run() {
	        process();
	    }

	    private void process() {
	        System.out.println("Processing " + order.getOrderId() +
	                " by " + Thread.currentThread().getName());

	        if (inventory.processOrder(order.getItem(), order.getOrderId())) {
	            paymentService.processPayment(order.getOrderId());
	            String agent = agentManager.assignAgent();

	            System.out.println(order.getOrderId() +
	                    " assigned to " + agent);
	        }
	    }
	}	
