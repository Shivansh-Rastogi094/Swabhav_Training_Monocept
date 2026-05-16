package orderSystem;

public class ExpressOrder extends Order implements OrderVerification {

    public ExpressOrder(int id, String name, double amount) throws InvalidOrderException {

        super(id, name, amount);
        System.out.println("Express Order Created");
    }

    @Override
    public void processOrder() {

        System.out.println("Processing Express Order (Fast Delivery)");
    }

    @Override
    public boolean verifyOrder() {

        return orderAmount >= 200;
    }
}
