package q2;
abstract class Order {
    int orderId;
    String customerName;
    double amount;

    Order(int orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
    }

    public abstract void display();
}