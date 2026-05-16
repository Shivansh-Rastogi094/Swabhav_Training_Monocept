package q2;

class PriorityOrder extends Order {
    PriorityOrder(int id, String name, double amt) {
        super(id, name, amt);
    }

    public void display() {
        System.out.println("Priority Order -> ID: " + orderId +
                ", Name: " + customerName +
                ", Amount: " + amount);
    }
}