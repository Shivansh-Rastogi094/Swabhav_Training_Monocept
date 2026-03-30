package q1;

public class Main {
    public static void main(String[] args) {
        LibraryManager lm = new LibraryManager();
        java.util.Scanner sc = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Sort by Title");
            System.out.println("4. Issue Book");
            System.out.println("5. Process Issue");
            System.out.println("6. Remove Book");
            System.out.println("7. Exit");

            int ch = sc.nextInt();

            switch (ch) {
                case 1: lm.addBook(); break;
                case 2: lm.displayBooks(); break;
                case 3: lm.sortBooksByTitle(); break;
                case 4: lm.issueBook(); break;
                case 5: lm.processIssue(); break;
                case 6: lm.removeBook(); break;
                case 7: System.exit(0);
            }
        }
    }
}