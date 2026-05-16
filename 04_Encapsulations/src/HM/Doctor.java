package HM;

class Doctor extends Staff {

    private String specialization;

    Doctor(int id, String name, String department, String specialization) {
        super(id, name, department);

        if (specialization == null || specialization.isEmpty()) {
            System.out.println("Specialization cannot be empty.");
            return;
        }

        this.specialization = specialization;
    }

    String getSpecialization() {
        return specialization;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Role: Doctor");
        System.out.println("Specialization: " + specialization);
        System.out.println();
    }
}