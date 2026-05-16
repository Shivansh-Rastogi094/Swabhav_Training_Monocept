package q3;

class PostgraduateStudent extends Student {
    String specialization;

    PostgraduateStudent(int id, String name, String dept, String specialization) {
        super(id, name, dept);
        this.specialization = specialization;
    }

    public void display() {
        System.out.println("PG -> ID: " + id + ", Name: " + name +
                ", Dept: " + department + ", Spec: " + specialization +
                ", Avg: " + getAverage());
    }
}