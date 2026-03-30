package HM;

class Nurse extends Staff {

    private String shift;

    Nurse(int id, String name, String department, String shift) {
        super(id, name, department);

        if (shift == null || shift.isEmpty()) {
            System.out.println("Shift cannot be empty.");
            return;
        }

        this.shift = shift;
    }

    String getShift() {
        return shift;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Role: Nurse");
        System.out.println("Shift: " + shift);
        System.out.println();
    }
}