package q3;
import java.util.*;

abstract class Student implements Comparable<Student> {
    int id;
    String name;
    String department;
    Map<String, Integer> marks;

    Student(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.marks = new HashMap<>();
    }

    public void addMarks(String subject, int score) {
        marks.put(subject, score);
    }

    public double getAverage() {
        if (marks.isEmpty()) return 0;
        int sum = 0;
        for (int m : marks.values()) sum += m;
        return sum / (double) marks.size();
    }

    // Natural ordering → by average marks (descending)
    @Override
    public int compareTo(Student other) {
        return Double.compare(other.getAverage(), this.getAverage());
    }

    // Prevent duplicates (based on ID)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        return id == ((Student) o).id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public abstract void display();
}