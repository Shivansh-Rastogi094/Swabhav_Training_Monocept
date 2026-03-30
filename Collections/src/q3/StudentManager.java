package q3;
import java.util.*;

class StudentManager {
    Set<Student> students = new HashSet<>();
    Map<String, List<Student>> deptMap = new HashMap<>();
    Scanner sc;

    // ✅ Constructor (THIS IS WHAT ERROR NEEDS)
    public StudentManager(Scanner sc) {
        this.sc = sc;
    }

    private int getInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }
    }

    public void addStudent() {
        int id = getInt("Enter ID: ");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        System.out.println("1. UG  2. PG");
        int ch = getInt("Choice: ");

        Student s;

        if (ch == 1) {
            System.out.print("Enter Year: ");
            String year = sc.nextLine();
            s = new UndergraduateStudent(id, name, dept, year);
        } else {
            System.out.print("Enter Specialization: ");
            String spec = sc.nextLine();
            s = new PostgraduateStudent(id, name, dept, spec);
        }

        int n = getInt("How many subjects? ");
        for (int i = 0; i < n; i++) {
            System.out.print("Subject: ");
            String sub = sc.nextLine();

            int marks;
            while (true) {
                marks = getInt("Marks: ");
                if (marks >= 0 && marks <= 100) break;
                System.out.println("Marks must be between 0 and 100!");
            }

            s.addMarks(sub, marks);
        }

        if (students.add(s)) {
            deptMap.putIfAbsent(dept, new ArrayList<>());
            deptMap.get(dept).add(s);
            System.out.println("Student added.");
        } else {
            System.out.println("Duplicate ID not allowed!");
        }
    }

    public void displayAll() {
        for (Student s : students) {
            s.display();
        }
    }

    public void sortByRanking() {
        List<Student> list = new ArrayList<>(students);
        Collections.sort(list);

        System.out.println("=== Ranking ===");
        for (Student s : list) {
            s.display();
        }
    }

    public void sortByName() {
        List<Student> list = new ArrayList<>(students);
        list.sort(Comparator.comparing(s -> s.name));
        list.forEach(Student::display);
    }

    public void sortById() {
        List<Student> list = new ArrayList<>(students);
        list.sort(Comparator.comparingInt(s -> s.id));
        list.forEach(Student::display);
    }

    public void displayByDept() {
        for (String dept : deptMap.keySet()) {
            System.out.println("\nDepartment: " + dept);
            for (Student s : deptMap.get(dept)) {
                s.display();
            }
        }
    }

    public void removeLowPerformers() {
        double threshold = getInt("Enter minimum average: ");

        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {
            Student s = it.next();
            if (s.getAverage() < threshold) {
                it.remove();
                deptMap.get(s.department).remove(s);
            }
        }

        System.out.println("Low performers removed.");
    }
}