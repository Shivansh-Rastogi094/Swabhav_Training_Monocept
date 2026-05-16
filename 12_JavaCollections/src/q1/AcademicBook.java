package q1;
class AcademicBook extends Book {
    String subject;

    AcademicBook(int id, String title, String author, String subject) {
        super(id, title, author);
        this.subject = subject;
    }

    public void display() {
        System.out.println("Academic Book -> ID: " + id +
                ", Title: " + title +
                ", Author: " + author +
                ", Subject: " + subject);
    }
}