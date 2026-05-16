package q1;
import java.util.Objects;

abstract class Book {
    int id;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public abstract void display();

    // Prevent duplicates (based on ID)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book b = (Book) o;
        return id == b.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}