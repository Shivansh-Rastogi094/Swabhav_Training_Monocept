package q2;

class RegularOrder extends Order {
    RegularOrder(int id, String name, double amt) {
        super(id, name, amt);
    }

    public void display() {
        System.out.println("Regular Order -> ID: " + orderId +
                ", Name: " + customerName +
                ", Amount: " + amount);
    }
}