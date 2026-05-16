package orderSystem;

public abstract class Order {

	protected int orderId;
	protected String customerName;
	protected double orderAmount;

	static {
		System.out.println("Loading Order Fulfillment System...");
	}

	public Order(int id, String name, double amount) throws InvalidOrderException {

		System.out.println("Order Constructor Called");

		if (id <= 0)
			throw new InvalidOrderException("Order ID must be positive");

		if (name == null || name.trim().isEmpty())
			throw new InvalidOrderException("Customer name cannot be empty");

		if (amount <= 0)
			throw new InvalidOrderException("Order amount must be positive");

		orderId = id;
		customerName = name;
		orderAmount = amount;
	}

	public void displayOrder() {

		System.out.println("\nOrder ID: " + orderId);
		System.out.println("Customer Name: " + customerName);
		System.out.println("Order Amount: " + orderAmount);
	}

	public abstract void processOrder();
}
