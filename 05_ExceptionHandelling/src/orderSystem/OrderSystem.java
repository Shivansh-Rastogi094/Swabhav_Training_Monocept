package orderSystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderSystem {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Order> orders = new ArrayList<>();
        int choice = 0;

        do {

            System.out.println("\n===== Online Order Fulfillment System =====");
            System.out.println("1. Create Standard Order");
            System.out.println("2. Create Express Order");
            System.out.println("3. Create International Order");
            System.out.println("4. View All Orders");
            System.out.println("5. Process Orders");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            try {

                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                    case 2:
                    case 3:

                        int id = readOrderID();
                        String name = readCustomerName();
                        double amount = readOrderAmount();

                        Order order = null;

                        if (choice == 1)
                            order = new StandardOrder(id, name, amount);

                        else if (choice == 2)
                            order = new ExpressOrder(id, name, amount);

                        else
                            order = new InternationalOrder(id, name, amount);

                        orders.add(order);

                        System.out.println("Order created successfully!");
                        break;

                    case 4:

                        if (orders.isEmpty())
                            System.out.println("No orders available.");

                        else
                            for (Order o : orders)
                                o.displayOrder();

                        break;

                    case 5:

                        if (orders.isEmpty()) {
                            System.out.println("No orders to process.");
                            break;
                        }

                        for (Order o : orders) {

                            o.displayOrder();

                            OrderVerification verify = (OrderVerification) o;

                            if (verify.verifyOrder())
                                o.processOrder();
                            else
                                System.out.println("Order verification failed!");

                            System.out.println("----------------------");
                        }

                        break;

                    case 6:
                        System.out.println("Exiting system...");
                        break;

                    default:
                        System.out.println("Invalid menu choice.");
                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid input type! Please enter correct value.");
                sc.nextLine();
            } catch (InvalidOrderException e) {

                System.out.println("Order Error: " + e.getMessage());
            }

        } while (choice != 6);

        sc.close();
    }

    
    // VALIDATION METHODS


    static int readOrderID() {

        while (true) {

            System.out.print("Enter Order ID: ");

            if (!sc.hasNextInt()) {
                System.out.println("Order ID must be numeric.");
                sc.next();
                continue;
            }

            int id = sc.nextInt();

            if (id <= 0) {
                System.out.println("Order ID must be positive.");
                continue;
            }

            return id;
        }
    }

    static String readCustomerName() {

        sc.nextLine();

        while (true) {

            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
                continue;
            }

            if (!name.matches("[a-zA-Z ]+")) {
                System.out.println("Name should contain only letters.");
                continue;
            }

            return name;
        }
    }

    static double readOrderAmount() {

        while (true) {

            System.out.print("Enter Order Amount: ");

            if (!sc.hasNextDouble()) {
                System.out.println("Invalid amount.");
                sc.next();
                continue;
            }

            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Order amount must be positive.");
                continue;
            }

            return amount;
        }
    }
}
