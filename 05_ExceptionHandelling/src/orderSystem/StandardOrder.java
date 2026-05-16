package orderSystem;

public class StandardOrder extends Order implements OrderVerification {

	public StandardOrder(int id, String name, double amount) throws InvalidOrderException {

		super(id, name, amount);
		System.out.println("Standard Order Created");
	}

	@Override
	public void processOrder() {

		System.out.println("Processing Standard Order");
	}

	@Override
	public boolean verifyOrder() {

		return orderAmount >= 100;
	}
}
