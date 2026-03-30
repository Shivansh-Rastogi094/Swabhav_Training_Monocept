package q2;

public class Main {
    public static void main(String[] args) {
        OrderManager om = new OrderManager();
        java.util.Scanner sc = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("\n--- Order Menu ---");
            System.out.println("1. Add Order");
            System.out.println("2. Dispatch Order");
            System.out.println("3. Sort by Amount");
            System.out.println("4. Remove Invalid Orders");
            System.out.println("5. Display by Customer");
            System.out.println("6. Exit");

            int ch = sc.nextInt();

            switch (ch) {
                case 1: om.addOrder(); break;
                case 2: om.dispatch(); break;
                case 3: om.sortOrdersByAmount(); break;
                case 4: om.removeInvalidOrders(); break;
                case 5: om.displayByCustomer(); break;
                case 6: System.exit(0);
            }
            sc.close();  
        }
        }
    
}