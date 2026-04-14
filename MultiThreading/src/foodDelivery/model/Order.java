package foodDelivery.model;

public class Order {
	    private String orderId;
	    private String item;
	    private OrderType type;

	    public Order(String orderId, String item, OrderType type) {
	        this.orderId = orderId;
	        this.item = item;
	        this.type = type;
	    }

	    public String getOrderId() {
	        return orderId;
	    }

	    public String getItem() {
	        return item;
	    }

	    public OrderType getType() {
	        return type;
	    }
	}
