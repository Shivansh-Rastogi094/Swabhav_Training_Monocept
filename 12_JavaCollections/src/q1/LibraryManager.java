package q1;
import java.util.*;

class LibraryManager {
    Set<Book> books = new HashSet<>();
    Queue<Book> issueQueue = new LinkedList<>();

    Scanner sc = new Scanner(System.in);

    // Input validation
    private int getIntInput(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
    }

    public void addBook() {
        int id = getIntInput("Enter Book ID: ");
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        System.out.println("1. Academic Book\n2. Magazine");
        int choice = getIntInput("Choose type: ");

        Book b = null;

        if (choice == 1) {
            System.out.print("Enter Subject: ");
            String subject = sc.nextLine();
            b = new AcademicBook(id, title, author, subject);
        } else if (choice == 2) {
            int issue = getIntInput("Enter Issue Number: ");
            b = new Magazine(id, title, author, issue);
        }

        if (books.add(b)) {
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Duplicate Book ID not allowed!");
        }
    }

    public void displayBooks() {
        for (Book b : books) {
            b.display();
        }
    }

    public void sortBooksByTitle() {
        List<Book> list = new ArrayList<>(books);
        list.sort(Comparator.comparing(b -> b.title));

        list.forEach(Book::display);
    }

    public void issueBook() {
        int id = getIntInput("Enter Book ID to issue: ");
        for (Book b : books) {
            if (b.id == id) {
                issueQueue.add(b);
                System.out.println("Book added to issue queue.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void processIssue() {
        if (issueQueue.isEmpty()) {
            System.out.println("No requests.");
        } else {
            Book b = issueQueue.poll();
            System.out.println("Issued: ");
            b.display();
        }
    }

    public void removeBook() {
        int id = getIntInput("Enter ID to remove: ");

        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            if (b.id == id) {
                it.remove();
                System.out.println("Removed successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}