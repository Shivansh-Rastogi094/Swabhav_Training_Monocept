package q3;
class UndergraduateStudent extends Student {
    String year;

    UndergraduateStudent(int id, String name, String dept, String year) {
        super(id, name, dept);
        this.year = year;
    }

    public void display() {
        System.out.println("UG -> ID: " + id + ", Name: " + name +
                ", Dept: " + department + ", Year: " + year +
                ", Avg: " + getAverage());
    }
}