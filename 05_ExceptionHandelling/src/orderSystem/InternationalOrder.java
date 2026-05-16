package orderSystem;

public class InternationalOrder extends Order implements OrderVerification {

    public InternationalOrder(int id, String name, double amount) throws InvalidOrderException {

        super(id, name, amount);
        System.out.println("International Order Created");
    }

    @Override
    public void processOrder() {

        System.out.println("Processing International Order (Customs + Shipping)");
    }

    @Override
    public boolean verifyOrder() {

        return orderAmount >= 500;
    }
}
