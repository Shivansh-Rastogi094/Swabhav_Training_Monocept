package HM;

class Staff {

    private int id;
    private String name;
    private String department;

    Staff(int id, String name, String department) {

        if (id <= 0) {
            System.out.println("Invalid ID. ID must be positive.");
            return;
        }

        if (name == null || name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        if (department == null || department.isEmpty()) {
            System.out.println("Department cannot be empty.");
            return;
        }

        this.id = id;
        this.name = name;
        this.department = department;
    }

    String getName() {
        return name;
    }

    void setDepartment(String department) {
        this.department = department;
    }

    void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
    }
}