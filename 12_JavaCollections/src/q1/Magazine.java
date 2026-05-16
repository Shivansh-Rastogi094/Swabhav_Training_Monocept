package q1;
class Magazine extends Book {
    int issueNumber;

    Magazine(int id, String title, String author, int issueNumber) {
        super(id, title, author);
        this.issueNumber = issueNumber;
    }

    public void display() {
        System.out.println("Magazine -> ID: " + id +
                ", Title: " + title +
                ", Author: " + author +
                ", Issue: " + issueNumber);
    }
}