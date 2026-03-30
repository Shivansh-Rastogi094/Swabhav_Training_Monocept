package q3;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        StudentManager sm = new StudentManager(sc); // pass scanner

        while (true) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All");
            System.out.println("3. Ranking (By Avg Marks)");
            System.out.println("4. Sort by Name");
            System.out.println("5. Sort by ID");
            System.out.println("6. Department-wise View");
            System.out.println("7. Remove Low Performers");
            System.out.println("8. Exit");

            int ch = sc.nextInt();
            sc.nextLine(); 

            switch (ch) {
                case 1: sm.addStudent(); break;
                case 2: sm.displayAll(); break;
                case 3: sm.sortByRanking(); break;
                case 4: sm.sortByName(); break;
                case 5: sm.sortById(); break;
                case 6: sm.displayByDept(); break;
                case 7: sm.removeLowPerformers(); break;
                case 8:
                    System.out.println("Exiting...");
                    return; 
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}