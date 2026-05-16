package q2;
import java.util.*;

class OrderManager {
    List<Order> orders = new ArrayList<>();
    Queue<Order> dispatchQueue = new LinkedList<>();
    Set<Integer> processed = new HashSet<>();
    Map<String, List<Order>> customerMap = new HashMap<>();

    Scanner sc = new Scanner(System.in);

    private int getInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }
    }

    public void addOrder() {
        int id = getInt("Enter Order ID: ");
        System.out.print("Customer Name: ");
        String name = sc.nextLine();
        double amt = Double.parseDouble(sc.nextLine());

        System.out.println("1. Regular\n2. Priority");
        int ch = getInt("Choice: ");

        Order o = (ch == 2)
                ? new PriorityOrder(id, name, amt)
                : new RegularOrder(id, name, amt);

        orders.add(o);
        dispatchQueue.add(o);

        customerMap.putIfAbsent(name, new ArrayList<>());
        customerMap.get(name).add(o);

        System.out.println("Order added.");
    }

    public void dispatch() {
        if (dispatchQueue.isEmpty()) {
            System.out.println("No orders.");
            return;
        }

        Order o = dispatchQueue.poll();

        if (processed.contains(o.orderId)) {
            System.out.println("Already processed.");
            return;
        }

        processed.add(o.orderId);
        System.out.println("Dispatched:");
        o.display();
    }

    public void sortOrdersByAmount() {
        orders.sort((o1, o2) -> Double.compare(o2.amount, o1.amount));
        orders.forEach(Order::display);
    }

    public void removeInvalidOrders() {
        Iterator<Order> it = orders.iterator();
        while (it.hasNext()) {
            Order o = it.next();
            if (o.amount <= 0) {
                it.remove();
            }
        }
        System.out.println("Invalid orders removed.");
    }

    public void displayByCustomer() {
        for (String name : customerMap.keySet()) {
            System.out.println("Customer: " + name);
            for (Order o : customerMap.get(name)) {
                o.display();
            }
        }
    }
}