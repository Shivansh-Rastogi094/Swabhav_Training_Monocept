package foodDelivery.service;

//package foodDelivery.service;
import java.util.concurrent.locks.ReentrantLock;

public class Inventory {
    private int pizza;
    private int burger;

    private final ReentrantLock lock = new ReentrantLock();

    public Inventory(int pizza, int burger) {
        this.pizza = pizza;
        this.burger = burger;
    }

    public boolean processOrder(String item, String orderId) {
        lock.lock();
        try {
            if (item.equalsIgnoreCase("pizza")) {
                if (pizza > 0) {
                    pizza--;
                    System.out.println("Inventory updated: Pizza remaining = " + pizza);
                    return true;
                } else {
                    System.out.println(orderId + " failed: Pizza out of stock");
                    return false;
                }
            } else if (item.equalsIgnoreCase("burger")) {
                if (burger > 0) {
                    burger--;
                    System.out.println("Inventory updated: Burger remaining = " + burger);
                    return true;
                } else {
                    System.out.println(orderId + " failed: Burger out of stock");
                    return false;
                }
            } else {
                System.out.println("Invalid item for " + orderId);
                return false;
            }
        } finally {
            lock.unlock();
        }
    }
}